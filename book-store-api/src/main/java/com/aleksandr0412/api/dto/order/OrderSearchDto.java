package com.aleksandr0412.api.dto.order;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Класс дто для поиска заказов
 */
public class OrderSearchDto {
    /**
     * пк пользователя, совершившего заказ
     */
    private UUID userId;
    /**
     * мин цена книги
     */
    private BigDecimal minPrice;
    /**
     * макс цена книги
     */
    private BigDecimal maxPrice;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
}
