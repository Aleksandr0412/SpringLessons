package com.aleksandr0412.bookstore.dao.springJdbc.impl;

import com.aleksandr0412.bookstore.dao.springJdbc.AuthorJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.mapper.AuthorRowMapper;
import com.aleksandr0412.bookstore.model.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.aleksandr0412.bookstore.dao.springJdbc.mapper.AuthorRowMapper.AUTHOR_ID;
import static com.aleksandr0412.bookstore.dao.springJdbc.mapper.AuthorRowMapper.AUTHOR_NAME;

@Repository
public class AuthorJdbcImpl implements AuthorJdbcDAO {
    public static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM authors WHERE id = ?";
    public static final String DELETE_FROM_AUTHORS = "DELETE FROM authors WHERE id = ?";
    public static final String UPDATE_AUTHORS = "UPDATE authors SET name = ? where id = ?";
    public static final String SELECT_ALL_AUTHORS = "SELECT * FROM authors";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public AuthorJdbcImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert authorSimpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = authorSimpleJdbcInsert;
    }

    @Override
    public int save(Author ob) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(AUTHOR_ID, ob.getId());
        parameters.put(AUTHOR_NAME, ob.getName());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public Author getByPK(UUID key) {
        return jdbcTemplate.queryForObject(SELECT_AUTHOR_BY_ID, new Object[]{key}, new AuthorRowMapper());
    }

    @Override
    public int deleteByPK(UUID key) {
        return jdbcTemplate.update(DELETE_FROM_AUTHORS, key);
    }

    @Override
    public int update(Author ob) {
        return jdbcTemplate.update(UPDATE_AUTHORS, ob.getName(), ob.getId());
    }

    @Override
    public Collection<Author> getAll() {
        return jdbcTemplate.query(SELECT_ALL_AUTHORS, new AuthorRowMapper());
    }

}
