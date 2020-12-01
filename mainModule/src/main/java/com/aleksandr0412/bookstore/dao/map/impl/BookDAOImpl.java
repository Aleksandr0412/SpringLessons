package com.aleksandr0412.bookstore.dao.map.impl;

import com.aleksandr0412.bookstore.dao.map.BookDAO;
import com.aleksandr0412.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class BookDAOImpl extends AbstractDao<Book, UUID> implements BookDAO {
    public BookDAOImpl() {
        super(Book.class, new HashMap<>());
    }
}
