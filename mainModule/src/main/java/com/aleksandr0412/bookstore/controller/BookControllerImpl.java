package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.BookController;
import com.aleksandr0412.api.dto.BookDto;
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
public class BookControllerImpl implements BookController {
    private final BookService service;

    public BookControllerImpl(BookService service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public List<BookDto> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("{id}")
    @Override
    public BookDto getBookByPk(@PathVariable UUID id) {
        return service.getBookByPK(id);
    }

    @PostMapping
    @Override
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto, UriComponentsBuilder componentsBuilder) {
        BookDto result = service.addBook(bookDto);
        URI uri = componentsBuilder.path("/api/book/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @PutMapping("{id}")
    @Override
    public BookDto updateBook(@PathVariable UUID id, @RequestBody BookDto bookDto) {
        if (!bookDto.getId().equals(id)) {
            throw new ResourceNotFoundException("wrong id");
        }

        return service.updateBook(bookDto);
    }

    @DeleteMapping
    @Override
    public BookDto deleteBook(@RequestParam(value = "id") UUID id) {
        return service.deleteBookByPK(id);
    }
}
