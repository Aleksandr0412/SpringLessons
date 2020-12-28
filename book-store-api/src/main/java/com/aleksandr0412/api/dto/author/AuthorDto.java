package com.aleksandr0412.api.dto.author;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Модель автора")
public class AuthorDto {

    @ApiModelProperty(value = "Идентификатор автора", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8",
            allowEmptyValue = true)
    private UUID id;
    /**
     * Имя автора в формате Фамилмя И. О.
     */
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorDto() {
    }

    public AuthorDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
