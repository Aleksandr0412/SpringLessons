package com.aleksandr0412.bookstore.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Представление заказов в системе
 */
@Entity
@Table(name = "orders")
public class Order implements Identified<UUID> {
    /**
     * Идентификатор заказа
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    /**
     * Пользователь, создавший заказ
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;
    /**
     * Цена в рублях
     */
    @Column(name = "price")
    private BigDecimal price;
    /**
     * Список книг заказа
     */
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "book_order",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
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
