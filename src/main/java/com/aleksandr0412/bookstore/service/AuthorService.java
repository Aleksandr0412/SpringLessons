package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.controller.dto.AuthorDto;
import com.aleksandr0412.bookstore.model.Author;

import java.util.List;

/**
 * AuthorService
 */
public interface AuthorService {
    /**
     * Добавляет автора
     *
     * @param authorDto
     * @return добавленного автора
     */
    AuthorDto addAuthor(AuthorDto authorDto);

    /**
     * Получает автора по первичному ключу
     *
     * @param id
     * @return автора по заданному пк
     */
    AuthorDto getAuthorByPK(Long id);

    /**
     * Удаляет автора по первичному ключу
     *
     * @param id
     * @return автора по заданному пк
     */
    AuthorDto deleteAuthorByPK(Long id);

    /**
     * Обновляет автора
     *
     * @param authorDto обновленный автор
     * @return обновленного автора
     */
    AuthorDto updateAuthor(AuthorDto authorDto);

    /**
     * Возвращает список всех авторов
     *
     * @return всех авторов
     */
    List<AuthorDto> getAllAuthors();
}
