package com.aleksandr0412.api.dto.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Класс дто для поиска книг
 */
@ApiModel(description = "Модель для поиска по книгам")
public class BookSearchDto {

    @ApiModelProperty(value = "Название книги", example = "Властелин колец", required = true)
    private String title;

    @ApiModelProperty(value = "Жанр книги", example = "Книга, написанная Толкином", allowableValues = "FANTASY, CLASSICS, DETECTIVE, HORROR", required = true)
    private String genre;

    @ApiModelProperty(value = "Минимальная цена книги", example = "1234.00", required = true)
    private BigDecimal minPrice;

    @ApiModelProperty(value = "Максимальная цена книги", example = "1234.00", required = true)
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "Идентификатор автора книги", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8",
            required = true)
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
