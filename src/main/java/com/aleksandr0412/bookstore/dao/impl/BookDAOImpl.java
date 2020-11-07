package com.aleksandr0412.bookstore.dao.impl;

import com.aleksandr0412.bookstore.dao.BookDAO;
import com.aleksandr0412.bookstore.model.Book;

import java.util.HashMap;

public class BookDAOImpl extends AbstractDao<Book, Long> implements BookDAO {
    public BookDAOImpl() {
        super(Book.class, new HashMap<>());
    }
}
