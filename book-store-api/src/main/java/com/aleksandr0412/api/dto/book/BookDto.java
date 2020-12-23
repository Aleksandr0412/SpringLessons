package com.aleksandr0412.api.dto.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@ApiModel(description = "Модель книги")
public class BookDto {

    @ApiModelProperty(value = "Идентификатор книги", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8",
            allowEmptyValue = true)
    private UUID id;

    @ApiModelProperty(value = "Название книги", example = "Властелин колец", required = true)
    private String title;

    @ApiModelProperty(value = "Описание книги", example = "Книга, написанная Толкином", required = true)
    private String description;

    @ApiModelProperty(value = "Жанр книги", example = "Книга, написанная Толкином", allowableValues = "FANTASY, CLASSICS, DETECTIVE, HORROR", required = true)
    private String genre;

    @ApiModelProperty(value = "Цена книги", example = "1234.00", required = true)
    private BigDecimal price;

    @ApiModelProperty(value = "Дата публикации книги", required = true)
    private LocalDate publishDate;

    @ApiModelProperty(value = "Идентификатор автора книги", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8",
            required = true)
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
