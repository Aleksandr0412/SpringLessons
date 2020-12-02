package com.aleksandr0412.bookstore.model;

import java.util.UUID;

/**
 * Представление полбзователя в системе
 */
public class User implements Identified<UUID> {
    /**
     * Идентификатор пользователя
     */
    private UUID id;
    /**
     * Логин пользователя на английском
     */
    private String username;
    /**
     * Пароль
     */
    private String password;
    /**
     * Почта пользователя
     */
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
