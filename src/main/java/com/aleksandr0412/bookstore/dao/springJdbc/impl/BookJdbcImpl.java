package com.aleksandr0412.bookstore.dao.springJdbc.impl;

import com.aleksandr0412.bookstore.common.JdbcConstants;
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

import java.util.*;

import static com.aleksandr0412.bookstore.common.JdbcConstants.*;
import static com.aleksandr0412.bookstore.common.Queries.*;

@Repository
public class BookJdbcImpl implements BookJdbcDAO {
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, SimpleJdbcInsert simpleJdbcInsert, SimpleJdbcCall simpleJdbcCall) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        simpleJdbcInsert.withTableName("books");
    }

    @Override
    public int save(Book ob) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(BOOK_ID, ob.getId());
        parameters.put(BOOK_TITLE, ob.getTitle());
        parameters.put(JdbcConstants.BOOK_DESCRIPTION, ob.getDescription());
        parameters.put(BOOK_GENRE, ob.getGenre().name());
        //TODO какой тип
        parameters.put(BOOK_PRICE, ob.getPrice());
        parameters.put(BOOK_PUBLISH_DATE, ob.getPublishDate());
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

    public Collection<Book> getBookByAuthorId(UUID id) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("author_id", id);
        return namedParameterJdbcTemplate.query("SELECT * FROM books WHERE author_id = :author_id", namedParameters,
                new BookRowMapper());
    }
}
