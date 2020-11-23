package com.aleksandr0412.bookstore.dao.springJdbc.mapper;

import com.aleksandr0412.bookstore.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static com.aleksandr0412.bookstore.common.JdbcConstants.AUTHOR_ID;
import static com.aleksandr0412.bookstore.common.JdbcConstants.AUTHOR_NAME;

public class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Author author = new Author();
        author.setId(UUID.fromString(rs.getString(AUTHOR_ID)));
        author.setName(rs.getString(AUTHOR_NAME));
        return author;
    }
}
