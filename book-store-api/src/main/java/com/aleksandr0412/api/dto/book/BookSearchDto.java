package com.aleksandr0412.api.dto.book;

import java.math.BigDecimal;
import java.util.UUID;

public class BookSearchDto {
    /**
     * Название книги
     */
    private String title;
    /**
     * Жанр книги
     */
    private String genre;
    /**
     * Цена книги в рублях(min)
     */
    private BigDecimal minPrice;
    /**
     * Цена книги в рублях(max)
     */
    private BigDecimal maxPrice;
    /**
     * Автор книги
     */
    private UUID authorId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
}
