package com.aleksandr0412.bookstore.model;

import java.time.LocalDate;

/**
 * Представление книги в системе
 */
public class Book implements Identified<Long> {
    /**
     * Идентификатор книги
     */
    private Long id;
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
    private Long price;
    /**
     * Дата публикации книги
     */
    private LocalDate publishDate;
    /**
     * Автор книги
     */
    private Author author;

    @Override
    public Long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setId(Long id) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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
