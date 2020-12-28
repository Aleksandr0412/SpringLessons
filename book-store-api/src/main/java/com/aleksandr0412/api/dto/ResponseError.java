package com.aleksandr0412.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

/**
 * Класс дто ошибки
 */
@ApiModel(description = "Модель для ответа в результате ошибки")
public class ResponseError {

    @ApiModelProperty(value = "Идентификатор ошибки", example = "30ff2b2b-42dc-4a26-93c3-ec312b4819f8",
            required = true)
    private UUID id;

    @ApiModelProperty(value = "Код ошибки", example = "illegalArgumentException", required = true)
    private String code;

    @ApiModelProperty(value = "Сообщение ошибки", example = "Что-то пошло не так", required = true)
    private String message;

    @ApiModelProperty(value = "Идентификатор системы", example = "my-system", required = true)
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
