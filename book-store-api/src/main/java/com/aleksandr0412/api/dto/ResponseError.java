package com.aleksandr0412.api.dto;

import java.util.UUID;

/**
 * Класс дто ошибки
 */
public class ResponseError {
    /**
     * Идентификатор ошибки
     */
    private UUID id;
    /**
     * Код ошибки
     */
    private String code;
    /**
     * Сообшение ошибки
     */
    private String message;
    /**
     * Имя системы, в которой произошла ошибка
     */
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
