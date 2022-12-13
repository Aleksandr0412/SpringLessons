package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.BookController;
import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.book.BookDto;
import com.aleksandr0412.api.dto.book.BookSearchDto;
import com.aleksandr0412.bookstore.annotations.Audit;
import com.aleksandr0412.bookstore.constants.AuditCode;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
public class BookControllerImpl implements BookController {
    private final BookService service;
    private static final Logger log = LoggerFactory.getLogger(BookControllerImpl.class.getName());

    public BookControllerImpl(BookService service) {
        this.service = service;
    }

    @Override
    public PageDto<BookDto> getBooks(@RequestBody Search<BookSearchDto> bookSearchDto) {
        log.info("getBook with {} - start ", bookSearchDto);
        var result = service.getBooks(bookSearchDto);
        log.info("getBook end with {}, with result {}", bookSearchDto, result);

        return result;
    }

    @Override
    public BookDto getBookByPk(UUID id) {
        log.info("getBook with {} - start ", id);
        var result = service.getBookByPK(id);
        log.info("getBookend with {}, with result {}", id, result);

        return result;
    }

    @Audit(AuditCode.BOOK_CREATE)
    @Override
    public ResponseEntity<BookDto> createBook(BookDto bookDto, UriComponentsBuilder componentsBuilder) {
        log.debug("createBook with {} - start ", bookDto);
        var result = service.addBook(bookDto);
        URI uri = componentsBuilder.path("/api/book/" + result.getId()).buildAndExpand(result).toUri();
        log.debug("createBook with {}, with result {}", bookDto, result);

        return ResponseEntity.created(uri).body(result);
    }

    @Audit(AuditCode.BOOK_UPDATE)
    @Override
    public BookDto updateBook(UUID id, BookDto bookDto) {
        log.info("updateBook with {} - start ", bookDto);
        if (!bookDto.getId().equals(id)) {
            throw new ResourceNotFoundException("wrong id");
        }
        var result = service.updateBook(bookDto);
        log.info("updateBook with {}, with result {}", bookDto, result);

        return result;
    }

    @Audit(AuditCode.BOOK_DELETE)
    @Override
    public BookDto deleteBook(UUID id) {
        log.info("deleteBook with {} - start ", id);
        var result = service.deleteBookByPK(id);
        log.info("deleteBook with {}, with result {}", id, result);

        return result;
    }

}
