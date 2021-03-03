package com.aleksandr0412.bookstore.entity;

import com.aleksandr0412.bookstore.constants.AuditCode;
import com.aleksandr0412.bookstore.constants.EventCode;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuditMessage {

    /**
     * Идентификатор лога
     */
    private int id;

    /** Индентификатор события */
    private UUID uuid = UUID.randomUUID();

    /** Код-описание метода */
    private AuditCode auditCode;

    /** Статус события: START, SUCCESS, FAILURE */
    private EventCode eventCode;

    /** Время начала события */
    private LocalDateTime timeStart;

    /** Время окончания события */
    private LocalDateTime timeEnd;

    /** Имя пользователя */
    private String username;

    /** Входящие параметры */
    private String params;

    /** Возвращаемый результат */
    private String returnValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public AuditCode getAuditCode() {
        return auditCode;
    }

    public void setAuditCode(AuditCode auditCode) {
        this.auditCode = auditCode;
    }

    public EventCode getEventCode() {
        return eventCode;
    }

    public void setEventCode(EventCode eventCode) {
        this.eventCode = eventCode;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s",
                uuid, auditCode, eventCode, timeStart,
                timeEnd, username, params, returnValue
        );
    }
}
