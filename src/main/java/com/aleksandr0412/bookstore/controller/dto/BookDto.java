package com.aleksandr0412.bookstore.controller.dto;

import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class BookDto {
    /**
     * Идентификатор книги
     */
    private UUID id;
    /**
     * Название книги
     */
    private String title;
    /**
     * Аннотация книги
     */
    private String description;
    /**
     * Жанр книги
     */
    private Genre genre;
    /**
     * Цена книги в рублях
     */
    private BigDecimal price;
    /**
     * Дата публикации книги
     */
    private LocalDate publishDate;
    /**
     * Автор книги
     */
    private Author author;

    public BookDto() {
    }

    public BookDto(UUID id, String title, String description, Genre genre, BigDecimal price, LocalDate publishDate, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
