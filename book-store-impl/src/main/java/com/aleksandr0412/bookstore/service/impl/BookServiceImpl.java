package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.BookDto;
import com.aleksandr0412.bookstore.dao.springJdbc.BookJdbcDAO;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.service.BookService;
import com.aleksandr0412.bookstore.validator.BookDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private final BookJdbcDAO bookDAO;
    private final BookDtoValidator validator;
    private final MapperFacade mapperFacade;

    public BookServiceImpl(BookJdbcDAO bookDAO, BookDtoValidator validator, MapperFacade mapperFacade) {
        this.bookDAO = bookDAO;
        this.validator = validator;
        this.mapperFacade = mapperFacade;
    }

    @Transactional
    public BookDto addBook(BookDto bookDto) {
        validator.validate(bookDto);
        bookDto.setId(UUID.randomUUID());
        Book book = mapperFacade.map(bookDto, Book.class);
        bookDAO.save(book);

        return bookDto;
    }

    @Transactional(readOnly = true)
    public BookDto getBookByPK(UUID id) {
        Book book = bookDAO.getByPK(id);

        return mapperFacade.map(book, BookDto.class);
    }

    @Transactional
    public BookDto deleteBookByPK(UUID id) {
        Book book = bookDAO.getByPK(id);
        bookDAO.deleteByPK(id);
        return mapperFacade.map(book, BookDto.class);
    }

    @Transactional
    public BookDto updateBook(BookDto bookDto) {
        validator.validate(bookDto);
        Book book = mapperFacade.map(bookDto, Book.class);
        bookDAO.update(book);

        return bookDto;
    }

    @Transactional(readOnly = true)
    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookDAO.getAll()) {
            bookDtos.add(mapperFacade.map(book, BookDto.class));
        }
        return bookDtos;
    }

}
