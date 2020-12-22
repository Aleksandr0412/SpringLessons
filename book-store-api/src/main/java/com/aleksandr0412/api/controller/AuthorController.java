package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.author.AuthorDto;
import com.aleksandr0412.api.dto.author.AuthorSearchDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * AuthorController
 */
@RequestMapping("/api/author")
@Api(value = "API для работы с авторами")
public interface AuthorController {

    @GetMapping("/{id}")
    @ApiOperation(value = "Детальная информация по автору")
    AuthorDto getAuthor(@ApiParam(value = "Идентификатор автора", required = true) @PathVariable UUID id);

    @PostMapping
    @ApiOperation(value = "Создание автора")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Автор успешно создан"),
    })
    ResponseEntity<AuthorDto> createAuthor(@ApiParam(value = "ДТО автора", required = true) @RequestBody AuthorDto authorDto, UriComponentsBuilder componentsBuilder);

    @PutMapping("{id}")
    @ApiOperation(value = "Обновить автора")
    AuthorDto updateAuthor(@ApiParam(value = "Идентификатор автора", required = true) @PathVariable UUID id, @RequestBody AuthorDto authorDto);

    @DeleteMapping
    @ApiOperation(value = "Удалить автора")
    AuthorDto deleteAuthor(@ApiParam(value = "Идентификатор автора", required = true) @RequestParam(value = "id") UUID id);

    @GetMapping
    @ApiOperation(value = "Поиск по авторам")
    PageDto<AuthorDto> getAuthors(@ApiParam(value = "Дто для поиска автора", required = true) @RequestBody Search<AuthorSearchDto> authorSearchDto);
}
