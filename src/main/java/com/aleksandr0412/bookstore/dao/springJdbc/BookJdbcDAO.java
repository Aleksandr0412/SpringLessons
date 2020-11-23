package com.aleksandr0412.bookstore.dao.springJdbc;

import com.aleksandr0412.bookstore.model.Book;

import java.util.Collection;
import java.util.UUID;

public interface BookJdbcDAO extends GenericJdbcDAO<Book, UUID> {
    Collection<Book> getBookByAuthorId(UUID id);
}
