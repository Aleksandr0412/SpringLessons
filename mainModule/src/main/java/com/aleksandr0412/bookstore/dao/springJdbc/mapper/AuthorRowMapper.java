package com.aleksandr0412.bookstore.dao.springJdbc.mapper;

import com.aleksandr0412.bookstore.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AuthorRowMapper implements RowMapper<Author> {
    public static final String AUTHOR_ID = "id";
    public static final String AUTHOR_NAME = "name";

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Author author = new Author();
        author.setId(UUID.fromString(rs.getString(AUTHOR_ID)));
        author.setName(rs.getString(AUTHOR_NAME));
        return author;
    }
}
