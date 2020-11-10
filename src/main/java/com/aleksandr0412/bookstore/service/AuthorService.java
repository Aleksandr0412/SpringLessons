package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.model.Author;

import java.util.List;

/**
 * AuthorService
 */
public interface AuthorService {
    /**
     * Добавляет автора
     *
     * @param author
     * @return добавленного автора
     */
    Author addAuthor(Author author);

    /**
     * Получает автора по первичному ключу
     *
     * @param id
     * @return автора по заданному пк
     */
    Author getAuthorByPK(Long id);

    /**
     * Удаляет автора по первичному ключу
     *
     * @param id
     * @return автора по заданному пк
     */
    Author deleteAuthorByPK(Long id);

    /**
     * Обновляет автора
     *
     * @param author обновленный автор
     * @return обновленного автора
     */
    Author updateAuthor(Author author);

    /**
     * Возвращает список всех авторов
     *
     * @return всех авторов
     */
    List<Author> getAllAuthors();
}
