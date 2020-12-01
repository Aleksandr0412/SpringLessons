package com.aleksandr0412.bookstore.dao.springJdbc;

import com.aleksandr0412.bookstore.model.Identified;

import java.io.Serializable;
import java.util.Collection;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 *
 * @param <T>  тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public interface GenericJdbcDAO<T extends Identified<PK>, PK extends Serializable> {

    /**
     * Создает новую запись, соответствующую объекту object
     */
    int save(T ob);

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    T getByPK(PK key);

    /**
     * Удаляет запись об объекте по первоичном ключу
     *
     * @return
     */
    int deleteByPK(PK key);

    /**
     * Сохраняет состояние объекта
     *
     * @return
     */
    int update(T ob);

    /**
     * Возвращает список объектов соответствующих всем записям
     */
    Collection<T> getAll();

}
