package com.aleksandr0412.api.dto.order;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderSearchDto {
    private UUID userId;
    private BigDecimal minPrice;
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
