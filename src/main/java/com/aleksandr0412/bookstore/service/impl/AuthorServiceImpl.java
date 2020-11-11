package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.AuthorDto;
import com.aleksandr0412.bookstore.dao.AuthorDAO;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;

    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public AuthorDto addAuthor(AuthorDto authorDto) {
        Author author = new Author(authorDto.getId(), authorDto.getName(), authorDto.getBooks());
        authorDAO.save(author);
        return authorDto;
    }

    public AuthorDto getAuthorByPK(Long id) {
        Author author = authorDAO.getByPK(id);
        return new AuthorDto(author.getId(), author.getName(), author.getBooks());
    }

    public AuthorDto deleteAuthorByPK(Long id) {
        Author author = authorDAO.deleteByPK(id);
        return new AuthorDto(author.getId(), author.getName(), author.getBooks());
    }

    public AuthorDto updateAuthor(AuthorDto authorDto) {
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
