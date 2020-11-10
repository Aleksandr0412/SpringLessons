package com.aleksandr0412.bookstore.dao.impl;

import com.aleksandr0412.bookstore.dao.AuthorDAO;
import com.aleksandr0412.bookstore.model.Author;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AuthorDAOImpl extends AbstractDao<Author, Long> implements AuthorDAO {
    public AuthorDAOImpl() {
        super(Author.class, new HashMap<>());
    }
}
