package com.aleksandr0412.bookstore.entity;

import com.aleksandr0412.bookstore.constants.AuditCode;
import com.aleksandr0412.bookstore.constants.EventCode;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class EventLogEntity {

    /**
     * Идентификатор лога
     */
    private int id;

    /** Индентификатор события */
    private UUID uuid = UUID.randomUUID();

    /** Enum код, уникальный для кадого метода */
    private AuditCode auditCode;

    /** Enum код статусов события: START, SUCCESS, FAILURE */
    private EventCode logEventStatus;

    /** Время начала события */
    private Instant timeStart;

    /** Время окончания события */
    private Instant timeEnd;

    /** Имя пользователя */
    private String username = "";

    /** Входящие параметры */
    private String params;

    /** Исходящий результат */
    private String returnValue;

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s",
                uuid, auditCode, logEventStatus, timeStart,
                timeEnd, username, params, returnValue
        );
    }
}
