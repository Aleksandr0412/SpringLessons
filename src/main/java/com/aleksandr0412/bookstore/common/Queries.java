package com.aleksandr0412.bookstore.common;

public class Queries {
    public static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM authors WHERE id = ?";
    public static final String DELETE_FROM_AUTHORS = "DELETE FROM authors WHERE id = ?";
    public static final String UPDATE_AUTHORS = "UPDATE authors SET name = ? where id = ?";
    public static final String SELECT_ALL_AUTHORS = "SELECT * FROM authors";

    public static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    public static final String DELETE_FROM_BOOKS = "DELETE FROM books WHERE id = ?";
    public static final String UPDATE_BOOKS = "UPDATE authors " +
            "SET title = ?, description = ?, genre = ?, price = ?, publish_date = ?" +
            " where id = ?";
    public static final String SELECT_ALL_BOOKS = "SELECT * FROM books";

    public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String DELETE_FROM_USERS = "DELETE FROM users WHERE id = ?";
    public static final String UPDATE_USERS = "UPDATE users SET username = ?, password = ?, email = ?  where id = ?";
    public static final String SELECT_ALL_USERS = "SELECT * FROM users";

    public static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ?";
    public static final String DELETE_FROM_ORDERS = "DELETE FROM orders WHERE id = ?";
    public static final String UPDATE_ORDERS = "UPDATE orders SET price = ? where id = ?";
    public static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";

}
