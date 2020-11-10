package com.aleksandr0412.bookstore.dao.impl;

import com.aleksandr0412.bookstore.dao.BookDAO;
import com.aleksandr0412.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BookDAOImpl extends AbstractDao<Book, Long> implements BookDAO {
    public BookDAOImpl() {
        super(Book.class, new HashMap<>());
    }
}
