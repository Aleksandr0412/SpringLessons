package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

/**
 * com.aleksandr0412.bookstore.controller.controller.BookController
 */
public interface BookController {
    List<BookDto> getAllBooks();

    BookDto getBookByPk(UUID id);

    ResponseEntity<BookDto> createBook(BookDto bookDto, UriComponentsBuilder componentsBuilder);

    BookDto updateBook(UUID id, BookDto bookDto);

    BookDto deleteBook(UUID id);

}
