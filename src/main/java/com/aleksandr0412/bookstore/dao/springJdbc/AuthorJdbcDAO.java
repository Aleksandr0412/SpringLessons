package com.aleksandr0412.bookstore.dao.springJdbc;

import com.aleksandr0412.bookstore.dao.map.GenericDAO;
import com.aleksandr0412.bookstore.model.Author;

import java.util.UUID;

public interface AuthorJdbcDAO extends GenericJdbcDAO<Author, UUID> {
}
