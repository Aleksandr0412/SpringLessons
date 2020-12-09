package com.aleksandr0412.bookstore.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Представление книги в системе
 */
@Entity
@Table(name = "books")
public class Book implements Identified<UUID> {
    /**
     * Идентификатор книги
     */
    @Id
    @GeneratedValue
    private UUID id;
    /**
     * Название книги
     */
    @Column(name = "title")
    private String title;
    /**
     * Аннотация книги
     */
    @Column(name = "description")
    private String description;
    /**
     * Жанр книги
     */
    @Enumerated(EnumType.STRING)
    private Genre genre;
    /**
     * Цена книги в рублях
     */
    @Column(name = "price")
    private BigDecimal price;
    /**
     * Дата публикации книги
     */
    @Column(name = "publish_year")
    private LocalDate publishDate;
    /**
     * Автор книги
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
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
