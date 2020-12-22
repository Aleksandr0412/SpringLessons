package com.aleksandr0412.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Класс для поиска
 */
@ApiModel(description = "Модель для поиска по объекатам")
public class Search<T> {

    @ApiModelProperty(value = "Формат данных для поиска", allowEmptyValue = true)
    private T data;

    @ApiModelProperty(value = "Объект получения по страничного ответа", allowEmptyValue = true)
    private Page page;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
