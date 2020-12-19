package com.aleksandr0412.api.dto.author;

/**
 * Класс дто для поиска авторов
 */
public class AuthorSearchDto {
    /**
     * Имя автора
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
