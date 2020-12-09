package com.aleksandr0412.bookstore.service.impl.jdbc;

import com.aleksandr0412.api.dto.AuthorDto;
import com.aleksandr0412.bookstore.dao.springJdbc.AuthorJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.BookJdbcDAO;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.service.AuthorService;
import com.aleksandr0412.bookstore.validator.AuthorDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorJdbcDAO authorDAO;
    private final BookJdbcDAO bookDAO;
    private final AuthorDtoValidator validator;
    private final MapperFacade mapperFacade;

    public AuthorServiceImpl(AuthorJdbcDAO authorDAO, AuthorDtoValidator validator, BookJdbcDAO bookDAO, MapperFacade mapperFacade) {
        this.authorDAO = authorDAO;
        this.validator = validator;
        this.bookDAO = bookDAO;
        this.mapperFacade = mapperFacade;
    }

    @Transactional
    public AuthorDto addAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);
        authorDto.setId(UUID.randomUUID());
        Author author = mapperFacade.map(authorDto, Author.class);
        authorDAO.save(author);

        return authorDto;
    }

    @Transactional(readOnly = true)
    public AuthorDto getAuthorByPK(UUID id) {
        Author author = authorDAO.getByPK(id);
        return mapperFacade.map(author, AuthorDto.class);
    }

    @Transactional
    public AuthorDto deleteAuthorByPK(UUID id) {
        Author author = authorDAO.getByPK(id);
        authorDAO.deleteByPK(id);

        return mapperFacade.map(author, AuthorDto.class);
    }

    @Transactional
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);

        Author author = mapperFacade.map(authorDto, Author.class);
        authorDAO.update(author);
        return authorDto;
    }

    @Transactional(readOnly = true)
    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authorDAO.getAll()) {
            authorDtos.add(mapperFacade.map(author, AuthorDto.class));
        }
        return authorDtos;
    }
}
