package com.aleksandr0412.api.dto;

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
    private Set<UUID> booksIds;

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
        return booksIds;
    }

    public Set<UUID> getBooksIds() {
        return booksIds;
    }

    public void setBooksIds(Set<UUID> booksIds) {
        this.booksIds = booksIds;
    }

    public void setBooks(Set<UUID> books) {
        this.booksIds = books;
    }

    public AuthorDto() {
    }

    public AuthorDto(UUID id, String name, Set<UUID> booksIds) {
        this.id = id;
        this.name = name;
        this.booksIds = booksIds;
    }
}
