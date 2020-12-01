package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.AuthorDto;
import com.aleksandr0412.bookstore.dao.springJdbc.AuthorJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.BookJdbcDAO;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.service.AuthorService;
import com.aleksandr0412.bookstore.validator.AuthorDtoValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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

    @Transactional
    public AuthorDto addAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);
        Author author = new Author(UUID.randomUUID(), authorDto.getName());
        authorDto.setId(author.getId());
        authorDAO.save(author);
        return authorDto;
    }

    @Transactional(readOnly = true)
    public AuthorDto getAuthorByPK(UUID id) {
        Author author = authorDAO.getByPK(id);
        author.setBooks(new HashSet<>(bookDAO.getBookByAuthorId(id)));
        return new AuthorDto(author.getId(), author.getName(), getBooksUUID(author.getBooks()));
    }

    @Transactional
    public AuthorDto deleteAuthorByPK(UUID id) {
        Author author = authorDAO.getByPK(id);
        authorDAO.deleteByPK(id);
        return new AuthorDto(author.getId(), author.getName(), getBooksUUID(author.getBooks()));
    }

    @Transactional
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        validator.validate(authorDto);

        Author author = new Author(authorDto.getId(), authorDto.getName());
        authorDAO.update(author);
        return authorDto;
    }

    @Transactional(readOnly = true)
    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authorDAO.getAll()) {
            author.setBooks(new HashSet<>(bookDAO.getBookByAuthorId(author.getId())));
            authorDtos.add(new AuthorDto(author.getId(), author.getName(), getBooksUUID(author.getBooks())));
        }
        return authorDtos;
    }

    private Set<UUID> getBooksUUID(Set<Book> books) {
        return books.stream()
                .map(Book::getId)
                .collect(Collectors.toSet());
    }
}