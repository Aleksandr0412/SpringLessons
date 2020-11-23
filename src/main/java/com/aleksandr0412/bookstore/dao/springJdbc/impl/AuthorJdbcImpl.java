package com.aleksandr0412.bookstore.dao.springJdbc.impl;

import com.aleksandr0412.bookstore.dao.springJdbc.AuthorJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.mapper.AuthorRowMapper;
import com.aleksandr0412.bookstore.model.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.aleksandr0412.bookstore.common.JdbcConstants.AUTHOR_ID;
import static com.aleksandr0412.bookstore.common.JdbcConstants.AUTHOR_NAME;
import static com.aleksandr0412.bookstore.common.Queries.*;

public class AuthorJdbcImpl implements AuthorJdbcDAO {
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    public AuthorJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, SimpleJdbcInsert simpleJdbcInsert, SimpleJdbcCall simpleJdbcCall) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("authors");
    }

    @Override
    public int save(Author ob) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(AUTHOR_ID, ob.getId().toString());
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
        return jdbcTemplate.update(UPDATE_AUTHORS, ob.getName(), ob.getId().toString());
    }

    @Override
    public Collection<Author> getAll() {
        return jdbcTemplate.query(SELECT_ALL_AUTHORS, new AuthorRowMapper());
    }

}
