package com.aleksandr0412.bookstore.model;

import java.io.Serializable;

/**
 * Интерфейс идентифицируемых объектов.
 */
public interface Identified<PK extends Serializable> extends Serializable {

    /**
     * Возвращает идентификатор объекта
     */
    PK getId();
}
