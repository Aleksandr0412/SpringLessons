package com.aleksandr0412.bookstore.dao.impl;

import com.aleksandr0412.bookstore.dao.AuthorDAO;
import com.aleksandr0412.bookstore.model.Author;

import java.util.HashMap;

public class AuthorDAOImpl extends AbstractDao<Author, Long> implements AuthorDAO {
    public AuthorDAOImpl() {
        super(Author.class, new HashMap<>());
    }
}
