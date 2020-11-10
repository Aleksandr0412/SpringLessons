package com.aleksandr0412.bookstore.model;

import java.util.List;

/**
 * Представление заказов в системе
 */
public class Order implements Identified<Long> {
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

    @Override
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
