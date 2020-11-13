package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.AuthorDto;
import com.aleksandr0412.bookstore.dao.AuthorDAO;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.service.AuthorService;
import com.aleksandr0412.bookstore.validator.AuthorDtoValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;
    private AuthorDtoValidator validator;

    public AuthorServiceImpl(AuthorDAO authorDAO, AuthorDtoValidator validator) {
        this.authorDAO = authorDAO;
        this.validator = validator;
    }

    public AuthorDto addAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);
        Author author = new Author(UUID.randomUUID(), authorDto.getName(), authorDto.getBooks());
        authorDto.setId(author.getId());
        authorDAO.save(author);
        return authorDto;
    }

    public AuthorDto getAuthorByPK(UUID id) {
        Author author = authorDAO.getByPK(id);
        return new AuthorDto(author.getId(), author.getName(), author.getBooks());
    }

    public AuthorDto deleteAuthorByPK(UUID id) {
        Author author = authorDAO.deleteByPK(id);
        return new AuthorDto(author.getId(), author.getName(), author.getBooks());
    }

    public AuthorDto updateAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);

        Author author = new Author(authorDto.getId(), authorDto.getName(), authorDto.getBooks());
        authorDAO.update(author);
        return authorDto;
    }

    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authorDAO.getAll()) {
            authorDtos.add(new AuthorDto(author.getId(), author.getName(), author.getBooks()));
        }
        return authorDtos;
    }
}
