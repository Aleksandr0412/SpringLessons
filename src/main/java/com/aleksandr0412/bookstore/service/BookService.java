package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.dao.BookDAO;
import com.aleksandr0412.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Book addBook(Book book) {
        return bookDAO.save(book);
    }

    public Book getBookByPK(Long id) {
        return bookDAO.getByPK(id);
    }

    public Book deleteBookByPK(Long id) {
        return bookDAO.deleteByPK(id);
    }

    public Book updateBook(Book book) {
        return bookDAO.update(book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookDAO.getAll());
    }
}
