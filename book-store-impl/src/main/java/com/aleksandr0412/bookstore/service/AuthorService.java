package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.api.dto.AuthorDto;

import java.util.List;
import java.util.UUID;

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
    AuthorDto getAuthorByPK(UUID id);

    /**
     * Удаляет автора по первичному ключу
     *
     * @param id
     * @return автора по заданному пк
     */
    AuthorDto deleteAuthorByPK(UUID id);

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
