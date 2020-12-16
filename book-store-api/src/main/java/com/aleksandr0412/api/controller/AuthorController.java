package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.author.AuthorDto;
import com.aleksandr0412.api.dto.author.AuthorSearchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * AuthorController
 */
@RequestMapping("/api/author")
public interface AuthorController {
    /**
     * Возвращает автора по первичному ключу
     *
     * @param id - пк автора
     * @return автора по пк
     */
    @GetMapping("/{id}")
    AuthorDto getAuthor(@PathVariable UUID id);

    /**
     * @param authorDto
     * @param componentsBuilder
     * @return DTO созданного автора
     */
    @PostMapping
    ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto, UriComponentsBuilder componentsBuilder);

    /**
     * @param id
     * @param authorDto
     * @return DTO обновленного автора
     */
    @PutMapping("{id}")
    AuthorDto updateAuthor(@PathVariable UUID id, @RequestBody AuthorDto authorDto);

    /**
     * Удаляет автора
     *
     * @param id
     * @return ДТО удаленного автора
     */
    @DeleteMapping
    AuthorDto deleteAuthor(@RequestParam(value = "id") UUID id);

    /**
     * Возвращает авторов с учетом пагинизацией и поиска
     *
     * @param authorSearchDto
     * @return
     */
    @GetMapping
    PageDto<AuthorDto> getAuthors(@RequestBody Search<AuthorSearchDto> authorSearchDto);
}
