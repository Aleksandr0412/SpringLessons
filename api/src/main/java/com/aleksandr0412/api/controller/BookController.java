package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

/**
 * BookController
 */
@RequestMapping("api/book")
public interface BookController {
    /**
     * @return список всех книг
     */
    @GetMapping
    List<BookDto> getAllBooks();

    /**
     * @param id пк книги
     * @return книгу по пк
     */
    @GetMapping("{id}")
    BookDto getBookByPk(@PathVariable UUID id);

    /**
     * @param bookDto           сохраняемая книга
     * @param componentsBuilder
     * @return созданную книгу
     */
    @PostMapping
    ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto, UriComponentsBuilder componentsBuilder);

    /**
     * @param id      пк книги
     * @param bookDto
     * @return измененную книгу
     */
    @PutMapping("{id}")
    BookDto updateBook(@PathVariable UUID id, @RequestBody BookDto bookDto);

    /**
     * @param id пк книги
     * @return удаленную книгу
     */
    @DeleteMapping
    BookDto deleteBook(@RequestParam(value = "id") UUID id);

}
