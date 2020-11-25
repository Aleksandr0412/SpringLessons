package com.aleksandr0412.bookstore.dao.springJdbc.impl;

import com.aleksandr0412.bookstore.dao.springJdbc.UserJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.mapper.UserRowMapper;
import com.aleksandr0412.bookstore.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.aleksandr0412.bookstore.dao.springJdbc.mapper.UserRowMapper.*;

@Repository
public class UserJdbcImpl implements UserJdbcDAO {
    public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String DELETE_FROM_USERS = "DELETE FROM users WHERE id = ?";
    public static final String UPDATE_USERS = "UPDATE users SET username = ?, password = ?, email = ?  where id = ?";
    public static final String SELECT_ALL_USERS = "SELECT * FROM users";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public UserJdbcImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert userSimpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = userSimpleJdbcInsert;
    }

    @Override
    public int save(User ob) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(USER_ID, ob.getId());
        parameters.put(USER_NAME, ob.getUsername());
        parameters.put(USER_PASSWORD, ob.getPassword());
        parameters.put(USER_EMAIL, ob.getEmail());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public User getByPK(UUID key) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new Object[]{key}, new UserRowMapper());
    }

    @Override
    public int deleteByPK(UUID key) {
        return jdbcTemplate.update(DELETE_FROM_USERS, key);
    }

    @Override
    public int update(User ob) {
        return jdbcTemplate.update(UPDATE_USERS, ob.getUsername(), ob.getPassword(), ob.getEmail(), ob.getId().toString());
    }

    @Override
    public Collection<User> getAll() {
        return jdbcTemplate.query(SELECT_ALL_USERS, new UserRowMapper());
    }
}
