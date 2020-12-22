package com.aleksandr0412.api.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@ApiModel(description = "Модель заказа")
public class OrderDto {

    @ApiModelProperty(value = "Идентификатор заказа", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8",
            allowEmptyValue = true)
    private UUID id;

    @ApiModelProperty(value = "Идентификатор пользователя, оформившего заказ", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8", required = true)
    private UUID userId;

    @ApiModelProperty(value = "Сумма заказа", example = "123", required = true)
    private BigDecimal price;

    @ApiModelProperty(value = "Список идентификаторов книг заказа", required = true)
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
