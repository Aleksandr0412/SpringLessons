package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.BookController;
import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.book.BookDto;
import com.aleksandr0412.api.dto.book.BookSearchDto;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
public class BookControllerImpl implements BookController {
    private final BookService service;

    public BookControllerImpl(BookService service) {
        this.service = service;
    }

    @Override
    public PageDto<BookDto> getBooks(@RequestBody Search<BookSearchDto> bookSearchDto) {
        var result = service.getBooks(bookSearchDto);
        return result;
    }

    @Override
    public BookDto getBookByPk(UUID id) {
        return service.getBookByPK(id);
    }

    @Override
    public ResponseEntity<BookDto> createBook(BookDto bookDto, UriComponentsBuilder componentsBuilder) {
        BookDto result = service.addBook(bookDto);
        URI uri = componentsBuilder.path("/api/book/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @Override
    public BookDto updateBook(UUID id, BookDto bookDto) {
        if (!bookDto.getId().equals(id)) {
            throw new ResourceNotFoundException("wrong id");
        }

        return service.updateBook(bookDto);
    }

    @Override
    public BookDto deleteBook(UUID id) {
        return service.deleteBookByPK(id);
    }

}
