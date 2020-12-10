package com.aleksandr0412.bookstore.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Представление автора книги в системе
 */
@Entity
@Table(name = "authors")
public class Author implements Identified<UUID> {
    /**
     * Идентификатор автора
     */
    @Id
    @GeneratedValue
    private UUID id;
    /**
     * Имя автора в формате Фамилмя И. О.
     */
    @Column(name = "name")
    private String name;

    public Author(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author() {
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
