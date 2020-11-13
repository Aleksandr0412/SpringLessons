package com.aleksandr0412.bookstore.controller.dto;

import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderDto {
    /**
     * Идентификатор заказа
     */
    private UUID id;
    /**
     * Пользователь, создавший заказ
     */
    private User user;
    /**
     * Цена в рублях
     */
    private BigDecimal price;
    /**
     * Список книг заказа
     */
    private List<Book> books;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public OrderDto() {
    }

    public OrderDto(UUID id, User user, BigDecimal price, List<Book> books) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.books = books;
    }
}
