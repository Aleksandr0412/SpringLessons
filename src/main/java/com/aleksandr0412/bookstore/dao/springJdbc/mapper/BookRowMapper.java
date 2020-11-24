package com.aleksandr0412.bookstore.dao.springJdbc.mapper;

import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BookRowMapper implements RowMapper<Book> {
    public static final String BOOK_ID = "id";
    public static final String BOOK_TITLE = "title";
    public static final String BOOK_DESCRIPTION = "description";
    public static final String BOOK_GENRE = "genre";
    public static final String BOOK_PRICE = "price";
    public static final String BOOK_PUBLISH_YEAR = "publish_year";
    public static final String BOOK_AUTHOR_ID = "author_id";
    public static final String BOOK_AUTHOR_NAME = "name";

    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        final Book book = new Book();
        book.setId(UUID.fromString(resultSet.getString(BOOK_ID)));
        book.setTitle(resultSet.getString(BOOK_TITLE));
        book.setDescription(resultSet.getString(BOOK_DESCRIPTION));
        book.setGenre(Genre.valueOf(resultSet.getString(BOOK_GENRE)));
        book.setPrice(new BigDecimal(resultSet.getString(BOOK_PRICE)));
//        book.setPublishDate((resultSet.getDate(BOOK_PUBLISH_YEAR)).toLocalDate());
        book.setPublishDate((resultSet.getDate(BOOK_PUBLISH_YEAR)) != null ? (resultSet.getDate(BOOK_PUBLISH_YEAR)).toLocalDate() : null);
        book.setAuthor(new Author(UUID.fromString(resultSet.getString(BOOK_AUTHOR_ID)),
                resultSet.getString(BOOK_AUTHOR_NAME)));
        return book;
    }
}
