package com.aleksandr0412.bookstore.dao.springJdbc.mapper;

import com.aleksandr0412.bookstore.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<User> {
    public static final String USER_ID = "id";
    public static final String USER_NAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        final User user = new User();
        user.setId(UUID.fromString(resultSet.getString(USER_ID)));
        user.setUsername(resultSet.getString(USER_NAME));
        user.setPassword(resultSet.getString(USER_PASSWORD));
        user.setEmail(resultSet.getString(USER_EMAIL));
        return user;
    }
}
