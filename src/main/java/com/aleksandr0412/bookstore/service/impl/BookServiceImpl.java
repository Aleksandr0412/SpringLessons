package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.BookDto;
import com.aleksandr0412.bookstore.dao.BookDAO;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.service.BookService;
import com.aleksandr0412.bookstore.validator.BookDtoValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    private BookDtoValidator validator;

    public BookServiceImpl(BookDAO bookDAO, BookDtoValidator validator) {
        this.bookDAO = bookDAO;
        this.validator = validator;
    }

    public BookDto addBook(BookDto bookDto) {
        validator.validate(bookDto);

        Book book = new Book(UUID.randomUUID(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getGenre(),
                bookDto.getPrice(), bookDto.getPublishDate(), bookDto.getAuthor());
        bookDto.setId(book.getId());
        bookDAO.save(book);
        return bookDto;
    }

    public BookDto getBookByPK(UUID id) {
        Book book = bookDAO.getByPK(id);
        return new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getGenre(),
                book.getPrice(), book.getPublishDate(), book.getAuthor());
    }

    public BookDto deleteBookByPK(UUID id) {
        Book book = bookDAO.deleteByPK(id);
        return new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getGenre(),
                book.getPrice(), book.getPublishDate(), book.getAuthor());
    }

    public BookDto updateBook(BookDto bookDto) {
        validator.validate(bookDto);

        Book book = new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getGenre(),
                bookDto.getPrice(), bookDto.getPublishDate(), bookDto.getAuthor());
        bookDAO.update(book);
        return bookDto;
    }

    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookDAO.getAll()) {
            bookDtos.add(new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getGenre(),
                    book.getPrice(), book.getPublishDate(), book.getAuthor()));
        }
        return bookDtos;
    }
}
