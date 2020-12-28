package com.aleksandr0412.api.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Класс дто для поиска заказов
 */
@ApiModel(description = "Модель для поиска по заказам")
public class OrderSearchDto {

    @ApiModelProperty(value = "Идентификатор пользователя, совершившего заказ", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8",
            required = true)
    private UUID userId;

    @ApiModelProperty(value = "Минимальная сумма заказа", example = "123.00", required = true)
    private BigDecimal minPrice;

    @ApiModelProperty(value = "Максимальная сумма заказа", example = "123.00", required = true)
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
