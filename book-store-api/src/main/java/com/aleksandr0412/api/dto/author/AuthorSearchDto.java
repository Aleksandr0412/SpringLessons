package com.aleksandr0412.api.dto.author;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Класс дто для поиска авторов
 */
@ApiModel(description = "Модель для поиска по авторам")
public class AuthorSearchDto {

    @ApiModelProperty(value = "Имя автора", example = "Пушкин А. С.", required = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
