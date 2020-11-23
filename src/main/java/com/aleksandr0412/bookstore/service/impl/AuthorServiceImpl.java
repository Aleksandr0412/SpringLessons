package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.AuthorDto;
import com.aleksandr0412.bookstore.dao.springJdbc.AuthorJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.BookJdbcDAO;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.service.AuthorService;
import com.aleksandr0412.bookstore.validator.AuthorDtoValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorJdbcDAO authorDAO;
    private final BookJdbcDAO bookDAO;
    private final AuthorDtoValidator validator;

    public AuthorServiceImpl(AuthorJdbcDAO authorDAO, AuthorDtoValidator validator, BookJdbcDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.validator = validator;
        this.bookDAO = bookDAO;
    }

    public AuthorDto addAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);
        Author author = new Author(UUID.randomUUID(), authorDto.getName());
        authorDto.setId(author.getId());
        authorDAO.save(author);
        return authorDto;
    }

    @Transactional
    public AuthorDto getAuthorByPK(UUID id) {
        Author author = authorDAO.getByPK(id);
        author.setBooks(new HashSet<>(bookDAO.getBookByAuthorId(id)));
        return new AuthorDto(author.getId(), author.getName(), author.getBooks());
    }

    @Transactional
    public AuthorDto deleteAuthorByPK(UUID id) {
        Author author = authorDAO.getByPK(id);
        authorDAO.deleteByPK(id);
        return new AuthorDto(author.getId(), author.getName(), author.getBooks());
    }

    public AuthorDto updateAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);

        Author author = new Author(authorDto.getId(), authorDto.getName());
        authorDAO.update(author);
        return authorDto;
    }

    @Transactional
    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authorDAO.getAll()) {
            author.setBooks(new HashSet<>(bookDAO.getBookByAuthorId(author.getId())));
            //TODO author.getBooks() так делается? вроде должно быть дто
            authorDtos.add(new AuthorDto(author.getId(), author.getName(), author.getBooks()));
        }
        return authorDtos;
    }
}
