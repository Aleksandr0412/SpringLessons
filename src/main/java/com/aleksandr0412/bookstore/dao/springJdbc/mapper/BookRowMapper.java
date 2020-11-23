package com.aleksandr0412.bookstore.dao.springJdbc.mapper;

import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

import static com.aleksandr0412.bookstore.common.JdbcConstants.*;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        final Book book = new Book();
        book.setId(UUID.fromString(resultSet.getString(BOOK_ID)));
        book.setTitle(resultSet.getString(BOOK_TITLE));
        book.setDescription(resultSet.getString(BOOK_DESCRIPTION));
        book.setGenre(Genre.valueOf(resultSet.getString(BOOK_GENRE)));
        book.setPrice(new BigDecimal(resultSet.getString(BOOK_PRICE)));
        //TODO
//        book.setPublishDate(resultSet.getObject(BOOK_PUBLISH_DATE, LocalDate.class));
        //TODO
        book.setAuthor(new Author(UUID.fromString(resultSet.getString("author_id")),
                resultSet.getString("name")));
        return book;
    }
}
