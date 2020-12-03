package com.aleksandr0412.api.dto;

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
    private String genre;
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
    private UUID authorId;

    public BookDto() {
    }

    public BookDto(UUID id, String title, String description, String genre, BigDecimal price, LocalDate publishDate, UUID authorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}