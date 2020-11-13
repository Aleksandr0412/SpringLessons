package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.bookstore.controller.dto.BookDto;
import com.aleksandr0412.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("{id}")
    public BookDto getBookByPk(@PathVariable Long id) {
        return service.getBookByPK(id);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return service.addBook(bookDto);
    }

    @PutMapping
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return service.updateBook(bookDto);
    }

    @DeleteMapping
    public BookDto deleteBook(@RequestParam(value = "id") Long id) {
        return service.deleteBookByPK(id);
    }
}
