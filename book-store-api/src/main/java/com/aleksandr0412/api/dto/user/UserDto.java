package com.aleksandr0412.api.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Модель пользователя")
public class UserDto {

    @ApiModelProperty(value = "Идентификатор пользователя", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8",
            allowEmptyValue = true)
    private UUID id;

    @ApiModelProperty(value = "Логин пользователя", example = "user1", required = true)
    private String username;

    @ApiModelProperty(value = "Пароль пользователя", example = "qwerty123!@#$", required = true)
    private String password;

    @ApiModelProperty(value = "email пользователя", example = "username@company.com", required = true)
    private String email;

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

    public UserDto() {
    }

    public UserDto(UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
