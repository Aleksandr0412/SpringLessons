package com.aleksandr0412.bookstore.dao;

import com.aleksandr0412.bookstore.model.Identified;

import java.io.Serializable;
import java.util.Collection;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 *
 * @param <T>  тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public interface GenericDAO<T extends Identified<PK>, PK extends Serializable> {

    /**
     * Создает новую запись, соответствующую объекту object
     */
    T save(T ob);

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    T getByPK(PK key);

    /**
     * Удаляет запись об объекте по первоичном ключу
     */
    T deleteByPK(PK key);

    /**
     * Сохраняет состояние объекта
     */
    T update(T ob);

    /**
     * Удаляет запись об объекте
     */
    T delete(T ob);

    /**
     * Возвращает список объектов соответствующих всем записям
     */
    Collection<T> getAll();

    /**
     * Создает новые записи, соответствующему списку объектов object
     */
    Collection<T> addAll(Collection<T> obs);
}
