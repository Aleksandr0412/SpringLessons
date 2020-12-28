package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.book.BookDto;
import com.aleksandr0412.api.dto.book.BookSearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * BookController
 */
@RequestMapping("api/book")
@Api(value = "API для работы с книгами")
public interface BookController {

    @GetMapping
    @ApiOperation(value = "Поиск по книгам")
    PageDto<BookDto> getBooks(@RequestBody Search<BookSearchDto> bookSearchDto);

    @GetMapping("{id}")
    @ApiOperation(value = "Детальная информация по книге")
    BookDto getBookByPk(@ApiParam(value = "Идентификатор книги", required = true) @PathVariable UUID id);

    @PostMapping
    @ApiOperation(value = "Создание книги")
    ResponseEntity<BookDto> createBook(@ApiParam(value = "ДТО книги", required = true) @RequestBody BookDto bookDto, UriComponentsBuilder componentsBuilder);

    @PutMapping("{id}")
    @ApiOperation(value = "Обновление книги")
    BookDto updateBook(@PathVariable UUID id, @RequestBody BookDto bookDto);

    @DeleteMapping
    @ApiOperation(value = "Удаление книги")
    BookDto deleteBook(@ApiParam(value = "Идентификатор книги", required = true) @RequestParam(value = "id") UUID id);

}
