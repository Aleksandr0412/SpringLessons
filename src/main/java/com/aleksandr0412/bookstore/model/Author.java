package com.aleksandr0412.bookstore.model;

import java.util.Set;

/**
 * Представление автора книги в системе
 */
public class Author implements Identified<Long> {
    /**
     * Идентификатор автора
     */
    private Long id;
    /**
     * Имя автора в формате Фамилмя И. О.
     */
    private String name;
    /**
     * Множество книг автора
     */
    private Set<Book> books;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
