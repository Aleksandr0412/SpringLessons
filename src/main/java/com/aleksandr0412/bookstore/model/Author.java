package com.aleksandr0412.bookstore.model;

import java.util.Set;
import java.util.UUID;

/**
 * Представление автора книги в системе
 */
public class Author implements Identified<UUID> {
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

    public Author() {
    }

    public Author(UUID id, String name, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    @Override
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
