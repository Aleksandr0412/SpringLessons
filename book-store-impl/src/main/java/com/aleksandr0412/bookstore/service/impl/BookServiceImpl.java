package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.book.BookDto;
import com.aleksandr0412.api.dto.book.BookSearchDto;
import com.aleksandr0412.bookstore.dao.repository.BookRepository;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.service.BookService;
import com.aleksandr0412.bookstore.service.specifications.BookSpecBuilder;
import com.aleksandr0412.bookstore.validator.BookDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Primary
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;
    private final BookDtoValidator validator;
    private final MapperFacade mapperFacade;
    private final BookSpecBuilder bookSpecBuilder;

    public BookServiceImpl(BookRepository bookRepo, BookDtoValidator validator, MapperFacade mapperFacade, BookSpecBuilder bookSpecBuilder) {
        this.bookRepo = bookRepo;
        this.validator = validator;
        this.mapperFacade = mapperFacade;
        this.bookSpecBuilder = bookSpecBuilder;
    }

    @Transactional
    @Override
    public BookDto addBook(BookDto bookDto) {
        validator.validate(bookDto);
        return mapperFacade.map(bookRepo.save(mapperFacade.map(bookDto, Book.class)), BookDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public BookDto getBookByPK(UUID id) {
        return mapperFacade.map(bookRepo.findById(id), BookDto.class);
    }

    @Transactional
    @Override
    public BookDto deleteBookByPK(UUID id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("bad id"));
        bookRepo.deleteById(id);
        return mapperFacade.map(book, BookDto.class);
    }

    @Transactional
    @Override
    public BookDto updateBook(BookDto bookDto) {
        validator.validate(bookDto);
        Book book = mapperFacade.map(bookDto, Book.class);
        return mapperFacade.map(bookRepo.save(book), BookDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDto> getAllBooks() {
        return mapperFacade.mapAsList(bookRepo.findAll(), BookDto.class);
    }


    @Transactional(readOnly = true)
    @Override
    public PageDto<BookDto> getBooks(Search<BookSearchDto> bookSearchDto) {
        Page<Book> page = bookRepo
                .findAll(bookSpecBuilder.getSpec(bookSearchDto.getData()), getOf(bookSearchDto));
        var books = page
                .map(book ->
                        mapperFacade.map(book, BookDto.class)
                )
                .toList();
        return new PageDto<>(books, page.getTotalElements());

    }

    private PageRequest getOf(Search<BookSearchDto> bookSearchDto) {
        var page = bookSearchDto.getPage();
        return PageRequest.of(page.getPage(), page.getSize());
    }
}
