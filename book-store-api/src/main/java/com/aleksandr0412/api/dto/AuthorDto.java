package com.aleksandr0412.api.dto;

import java.util.UUID;

public class AuthorDto {
    /**
     * Идентификатор автора
     */
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
