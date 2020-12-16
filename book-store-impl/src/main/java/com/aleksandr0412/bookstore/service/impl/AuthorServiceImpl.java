package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.author.AuthorDto;
import com.aleksandr0412.api.dto.author.AuthorSearchDto;
import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.bookstore.dao.repository.AuthorRepository;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.service.AuthorService;
import com.aleksandr0412.bookstore.validator.AuthorDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepo;
    private final AuthorDtoValidator validator;
    private final MapperFacade mapperFacade;

    public AuthorServiceImpl(AuthorRepository authorRepo, AuthorDtoValidator validator, MapperFacade mapperFacade) {
        this.authorRepo = authorRepo;
        this.validator = validator;
        this.mapperFacade = mapperFacade;
    }

    @Transactional
    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);
        Author author = mapperFacade.map(authorDto, Author.class);
        return mapperFacade.map(authorRepo.save(author), AuthorDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public AuthorDto getAuthorByPK(UUID id) {
        return mapperFacade.map(authorRepo.findById(id), AuthorDto.class);
    }

    @Transactional
    @Override
    public AuthorDto deleteAuthorByPK(UUID id) {
        Author author = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("bad author id"));
        authorRepo.deleteById(id);
        return mapperFacade.map(author, AuthorDto.class);
    }

    @Transactional
    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);
        if (authorRepo.existsById(authorDto.getId())) {
            Author map = mapperFacade.map(authorDto, Author.class);
            return mapperFacade.map(authorRepo.save(map), AuthorDto.class);
        } else throw new ResourceNotFoundException("bad id");
    }

    @Transactional(readOnly = true)
    @Override
    public List<AuthorDto> getAllAuthors() {
        return mapperFacade.mapAsList(authorRepo.findAll(), AuthorDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public PageDto<AuthorDto> getAuthors(Search<AuthorSearchDto> authorSearchDto) {
        Page<Author> page = authorRepo
                .findAll(getSpec(authorSearchDto.getData()), getOf(authorSearchDto));
        var authors = page
                .map(author ->
                        mapperFacade.map(author, AuthorDto.class)
                )
                .toList();
        return new PageDto<>(authors, page.getTotalElements());

    }

    private PageRequest getOf(Search<AuthorSearchDto> authorSearchDto) {
        var page = authorSearchDto.getPage();
        return PageRequest.of(page.getPage(), page.getSize());
    }

    private Specification<Author> getSpec(AuthorSearchDto authorSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (authorSearchDto.getName() != null) {
                predicates.add(root.get("name").in(authorSearchDto.getName()));
            }
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
