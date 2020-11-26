package com.aleksandr0412.bookstore.dao.springJdbc.impl;

import com.aleksandr0412.bookstore.dao.springJdbc.BookJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.mapper.BookRowMapper;
import com.aleksandr0412.bookstore.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.aleksandr0412.bookstore.dao.springJdbc.mapper.BookRowMapper.*;

@Repository
public class BookJdbcImpl implements BookJdbcDAO {
    public static final String SELECT_BOOK_BY_ID = "SELECT * FROM books INNER JOIN authors ON books.author_id = authors.id WHERE books.id = ? ";
    public static final String DELETE_FROM_BOOKS = "DELETE FROM books WHERE id = ?";
    public static final String UPDATE_BOOKS = "UPDATE books " +
            "SET title = ?, description = ?, genre = ?, price = ?, publish_date = ?" +
            " where id = ?";
    public static final String SELECT_ALL_BOOKS = "SELECT * FROM books INNER JOIN authors as author ON books.author_id = author.id";
    public static final String SELECT_BOOKS_BY_AUTHOR_ID = "SELECT * FROM books INNER JOIN authors ON books.author_id = authors.id WHERE author_id = :author_id";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, SimpleJdbcInsert bookSimpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = bookSimpleJdbcInsert;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int save(Book ob) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(BOOK_ID, ob.getId());
        parameters.put(BOOK_TITLE, ob.getTitle());
        parameters.put(BOOK_DESCRIPTION, ob.getDescription());
        parameters.put(BOOK_GENRE, ob.getGenre().name());
        parameters.put(BOOK_PRICE, ob.getPrice());
        parameters.put(BOOK_PUBLISH_YEAR, ob.getPublishDate());
        parameters.put(BOOK_AUTHOR_ID, ob.getAuthor().getId());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public Book getByPK(UUID key) {
        return jdbcTemplate.queryForObject(SELECT_BOOK_BY_ID, new Object[]{key}, new BookRowMapper());
    }

    @Override
    public int deleteByPK(UUID key) {
        return jdbcTemplate.update(DELETE_FROM_BOOKS, key);
    }

    @Override
    public int update(Book ob) {
        return jdbcTemplate.update(UPDATE_BOOKS, ob.getTitle(), ob.getDescription(), ob.getGenre().name(),
                ob.getPrice(), ob.getPublishDate(), ob.getAuthor().getId().toString(), ob.getId().toString());
    }

    @Override
    public Collection<Book> getAll() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS, new BookRowMapper());
    }

    @Override
    public Collection<Book> getBookByAuthorId(UUID id) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("author_id", id);
        return namedParameterJdbcTemplate.query(SELECT_BOOKS_BY_AUTHOR_ID, namedParameters,
                new BookRowMapper());
    }
}
