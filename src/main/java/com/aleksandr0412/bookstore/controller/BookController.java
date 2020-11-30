package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.bookstore.controller.dto.BookDto;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("{id}")
    public BookDto getBookByPk(@PathVariable UUID id) {
        return service.getBookByPK(id);
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto, UriComponentsBuilder componentsBuilder) {
        BookDto result = service.addBook(bookDto);
        URI uri = componentsBuilder.path("/api/book/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @PutMapping("{id}")
    public BookDto updateBook(@PathVariable UUID id, @RequestBody BookDto bookDto) {
        if (!bookDto.getId().equals(id)) {
            throw new ResourceNotFoundException("wrong id");
        }

        return service.updateBook(bookDto);
    }

    @DeleteMapping
    public BookDto deleteBook(@RequestParam(value = "id") UUID id) {
        return service.deleteBookByPK(id);
    }
}
