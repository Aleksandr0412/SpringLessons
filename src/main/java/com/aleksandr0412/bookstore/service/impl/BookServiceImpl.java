package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.BookDto;
import com.aleksandr0412.bookstore.dao.BookDAO;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public BookDto addBook(BookDto bookDto) {
        Book book = new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getGenre(),
                bookDto.getPrice(), bookDto.getPublishDate(), bookDto.getAuthor());
        bookDAO.save(book);
        return bookDto;
    }

    public BookDto getBookByPK(Long id) {
        Book book = bookDAO.getByPK(id);
        return new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getGenre(),
                book.getPrice(), book.getPublishDate(), book.getAuthor());
    }

    public BookDto deleteBookByPK(Long id) {
        Book book = bookDAO.deleteByPK(id);
        return new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getGenre(),
                book.getPrice(), book.getPublishDate(), book.getAuthor());
    }

    public BookDto updateBook(BookDto bookDto) {
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
