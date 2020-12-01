package com.aleksandr0412.bookstore.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Представление заказов в системе
 */
public class Order implements Identified<UUID> {
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

    public Order() {
    }

    public Order(UUID id, User user, BigDecimal price, List<Book> books) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.books = books;
    }

    @Override
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", price=" + price +
                ", books=" + books +
                '}';
    }
}
