package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.AuthorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

/**
 * com.aleksandr0412.bookstore.controller.controller.AuthorController
 */
public interface AuthorController {
    /**
     * Возвращает список всех авторов
     *
     * @return всех авторов
     */
    List<AuthorDto> getAllAuthors();

    /**
     * Возвращает автора по первичному ключу
     *
     * @param id - пк автора
     * @return автора по пк
     */
    AuthorDto getAuthor(UUID id);

    /**
     * @param authorDto
     * @param componentsBuilder
     * @return DTO созданного автора
     */
    ResponseEntity<AuthorDto> createAuthor(AuthorDto authorDto, UriComponentsBuilder componentsBuilder);

    /**
     * @param id
     * @param authorDto
     * @return DTO обновленного автора
     */
    AuthorDto updateAuthor(UUID id, AuthorDto authorDto);

    /**
     * Удаляет автора
     *
     * @param id
     * @return ДТО удаленного автора
     */
    AuthorDto deleteAuthor(UUID id);
}
