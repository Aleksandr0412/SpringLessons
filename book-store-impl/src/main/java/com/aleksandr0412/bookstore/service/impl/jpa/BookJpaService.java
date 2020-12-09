package com.aleksandr0412.bookstore.service.impl.jpa;

import com.aleksandr0412.api.dto.BookDto;
import com.aleksandr0412.bookstore.dao.repository.BookRepository;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.service.BookService;
import com.aleksandr0412.bookstore.validator.BookDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Primary
public class BookJpaService implements BookService {
    private final BookRepository bookRepo;
    private final BookDtoValidator validator;
    private final MapperFacade mapperFacade;

    public BookJpaService(BookRepository bookRepo, BookDtoValidator validator, MapperFacade mapperFacade) {
        this.bookRepo = bookRepo;
        this.validator = validator;
        this.mapperFacade = mapperFacade;
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
}
