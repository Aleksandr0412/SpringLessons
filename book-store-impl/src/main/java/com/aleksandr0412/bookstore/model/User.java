package com.aleksandr0412.bookstore.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Представление полбзователя в системе
 */
@Entity
@Table(name = "users")
public class User implements Identified<UUID> {
    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue
    private UUID id;
    /**
     * Логин пользователя на английском
     */
    @Column(name = "username")
    private String username;
    /**
     * Пароль
     */
    @Column(name = "password")
    private String password;
    /**
     * Почта пользователя
     */
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
