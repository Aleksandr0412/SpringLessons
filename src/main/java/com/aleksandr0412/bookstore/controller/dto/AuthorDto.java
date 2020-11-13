package com.aleksandr0412.bookstore.controller.dto;

import com.aleksandr0412.bookstore.model.Book;

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
    private Set<Book> books;

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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public AuthorDto() {
    }

    public AuthorDto(UUID id, String name, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }
}
