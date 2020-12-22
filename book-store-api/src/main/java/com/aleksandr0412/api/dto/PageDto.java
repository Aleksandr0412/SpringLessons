package com.aleksandr0412.api.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Класс дто для ппагинации
 */
@ApiModel(description = "Модель ответа для поиска по объекатам")
public class PageDto<T> {

    @ApiModelProperty(value = "Возращаемые данные по поиску", required = true)
    List<T> data;

    @ApiModelProperty(value = "Всего элементов по поиску", example = "123", required = true)
    long total;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public PageDto(List<T> data, long total) {
        this.data = data;
        this.total = total;
    }

    public PageDto() {
    }
}
