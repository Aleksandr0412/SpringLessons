package com.aleksandr0412.bookstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Представление книги в системе
 */
public class Book implements Identified<UUID> {
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

    public Book(UUID id, String title, String description, Genre genre, BigDecimal price, LocalDate publishDate, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Book() {

    }

    @Override
    public UUID getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre=" + genre +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", author=" + author +
                '}';
    }
}
