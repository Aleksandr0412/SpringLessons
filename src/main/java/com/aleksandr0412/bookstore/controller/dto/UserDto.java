package com.aleksandr0412.bookstore.controller.dto;

public class UserDto {
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

    public UserDto() {
    }

    public UserDto(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
