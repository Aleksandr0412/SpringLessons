package com.aleksandr0412.bookstore.controller.dto;

import java.util.UUID;

public class ResponseError {
    private UUID id;
    private String code;
    private String message;
    private String system;

    public ResponseError(UUID id, String code, String message, String system) {
        this.id = id;
        this.code = code;
        this.message = message;
        this.system = system;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
