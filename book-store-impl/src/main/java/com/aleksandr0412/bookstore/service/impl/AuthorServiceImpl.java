package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.AuthorDto;
import com.aleksandr0412.bookstore.dao.repository.AuthorRepository;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.service.AuthorService;
import com.aleksandr0412.bookstore.validator.AuthorDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return mapperFacade.map(authorRepo.save(mapperFacade.map(authorDto, Author.class)), AuthorDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AuthorDto> getAllAuthors() {
        return mapperFacade.mapAsList(authorRepo.findAll(), AuthorDto.class);
    }
}
