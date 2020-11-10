package com.aleksandr0412.bookstore.model;

/**
 * Представление полбзователя в системе
 */
public class User implements Identified<Long> {
    /**
     * Идентификатор пользователя
     */
    private Long id;
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

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
