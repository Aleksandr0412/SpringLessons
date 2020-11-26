package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.BookDto;
import com.aleksandr0412.bookstore.dao.springJdbc.AuthorJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.BookJdbcDAO;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.service.BookService;
import com.aleksandr0412.bookstore.validator.BookDtoValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private final BookJdbcDAO bookDAO;
    private final AuthorJdbcDAO authorDAO;
    private final BookDtoValidator validator;

    public BookServiceImpl(BookJdbcDAO bookDAO, AuthorJdbcDAO authorDAO, BookDtoValidator validator) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
        this.validator = validator;
    }

    @Transactional
    public BookDto addBook(BookDto bookDto) {
        validator.validate(bookDto);

        Book book = new Book(UUID.randomUUID(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getGenre(),
                bookDto.getPrice(), bookDto.getPublishDate(), authorDAO.getByPK(bookDto.getAuthorId()));
        bookDto.setId(book.getId());
        bookDAO.save(book);
        return bookDto;
    }

    @Transactional(readOnly = true)
    public BookDto getBookByPK(UUID id) {
        Book book = bookDAO.getByPK(id);
        return new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getGenre(),
                book.getPrice(), book.getPublishDate(), book.getAuthor().getId());
    }

    @Transactional
    public BookDto deleteBookByPK(UUID id) {
        Book book = bookDAO.getByPK(id);
        bookDAO.deleteByPK(id);
        return new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getGenre(),
                book.getPrice(), book.getPublishDate(), book.getAuthor().getId());
    }

    @Transactional
    public BookDto updateBook(BookDto bookDto) {
        validator.validate(bookDto);

        Book book = new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getGenre(),
                bookDto.getPrice(), bookDto.getPublishDate(), authorDAO.getByPK(bookDto.getAuthorId()));
        bookDAO.update(book);
        return bookDto;
    }

    @Transactional(readOnly = true)
    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookDAO.getAll()) {
            bookDtos.add(new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getGenre(),
                    book.getPrice(), book.getPublishDate(), book.getAuthor().getId()));
        }
        return bookDtos;
    }

}
