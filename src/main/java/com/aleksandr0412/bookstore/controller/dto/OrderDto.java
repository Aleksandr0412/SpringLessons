package com.aleksandr0412.bookstore.controller.dto;

import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.User;

import java.util.List;

public class OrderDto {
    /**
     * Идентификатор заказа
     */
    private Long id;
    /**
     * Пользователь, создавший заказ
     */
    private User user;
    /**
     * Цена в рублях
     */
    private Long price;
    /**
     * Список книг заказа
     */
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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

    public OrderDto(Long id, User user, Long price, List<Book> books) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.books = books;
    }
}
