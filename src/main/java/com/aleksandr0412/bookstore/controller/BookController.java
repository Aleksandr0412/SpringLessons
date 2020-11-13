package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.bookstore.controller.dto.BookDto;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Genre;
import com.aleksandr0412.bookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/book")
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        //TODO
        BookDto bookDto = new BookDto(UUID.randomUUID(), "lotr", "good", Genre.CLASSICS,
                new BigDecimal("12345566"), LocalDate.now(), new Author());
        service.addBook(bookDto);
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
        bookDto.setId(id);

        return service.updateBook(bookDto);
    }

    @DeleteMapping
    public BookDto deleteBook(@RequestParam(value = "id") UUID id) {
        return service.deleteBookByPK(id);
    }
}
