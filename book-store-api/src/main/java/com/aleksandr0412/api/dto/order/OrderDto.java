package com.aleksandr0412.api.dto.order;

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
    private UUID userId;
    /**
     * Цена в рублях
     */
    private BigDecimal price;
    /**
     * Список книг заказа
     */
    private List<UUID> bookIds;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<UUID> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<UUID> bookIds) {
        this.bookIds = bookIds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderDto() {
    }

    public OrderDto(UUID id, UUID userId, BigDecimal price, List<UUID> bookIds) {
        this.id = id;
        this.userId = userId;
        this.price = price;
        this.bookIds = bookIds;
    }
}
