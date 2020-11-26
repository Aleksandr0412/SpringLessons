package com.aleksandr0412.bookstore.controller.dto;

import java.util.Set;
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
    /**
     * Множество книг автора
     */
    private Set<UUID> booksId;

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

    public Set<UUID> getBooks() {
        return booksId;
    }

    public void setBooks(Set<UUID> books) {
        this.booksId = books;
    }

    public AuthorDto() {
    }

    public AuthorDto(UUID id, String name, Set<UUID> booksId) {
        this.id = id;
        this.name = name;
        this.booksId = booksId;
    }
}
