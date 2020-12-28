package com.aleksandr0412.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Класс для пагинации
 */
@ApiModel(description = "Объект получения по страничного ответа")
public class Page {

    @ApiModelProperty(value = "Номер страницы", example = "1", required = true)
    int page;

    @ApiModelProperty(value = "Количество элементов на странице", example = "5", required = true)
    int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
