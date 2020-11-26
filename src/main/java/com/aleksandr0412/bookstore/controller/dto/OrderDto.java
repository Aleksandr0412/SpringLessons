package com.aleksandr0412.bookstore.controller.dto;

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
    private UUID userUUID;
    /**
     * Цена в рублях
     */
    private BigDecimal price;
    /**
     * Список книг заказа
     */
    private List<UUID> booksUUID;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(UUID userUUID) {
        this.userUUID = userUUID;
    }

    public List<UUID> getBooksUUID() {
        return booksUUID;
    }

    public void setBooksUUID(List<UUID> booksUUID) {
        this.booksUUID = booksUUID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderDto() {
    }

    public OrderDto(UUID id, UUID userUUID, BigDecimal price, List<UUID> booksUUID) {
        this.id = id;
        this.userUUID = userUUID;
        this.price = price;
        this.booksUUID = booksUUID;
    }
}
