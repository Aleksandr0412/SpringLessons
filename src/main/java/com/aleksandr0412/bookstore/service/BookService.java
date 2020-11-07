package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.dao.BookDAO;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.model.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Book addBook(Book book) {
        return bookDAO.save(book);
    }

    public Book getBookByPK(Long id) {
        Book book;
        if ((book = bookDAO.getByPK(id)) != null) {
            return book;
        } else throw new ResourceNotFoundException("Book not found");
    }

    public Book deleteBookByPK(Long id) {
        if (bookDAO.getByPK(id) != null) {
            return bookDAO.deleteByPK(id);
        } else throw new ResourceNotFoundException("Book not found");
    }

    public Book updateBook(Book book) {
        return bookDAO.update(book);
    }

    public Book deleteBook(Book book) {
        if (bookDAO.getByPK(book.getId()) != null) {
            return bookDAO.delete(book);
        } else throw new ResourceNotFoundException("Book not found");
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookDAO.getAll());
    }

    public List<Book> addAllBooks(Collection<Book> books) {
        return new ArrayList<>(bookDAO.addAll(books));
    }
}
