package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.book.BookDto;
import com.aleksandr0412.api.dto.book.BookSearchDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * BookService
 */
public interface BookService {
    /**
     * Добавляет книгу
     *
     * @param bookDto
     * @return добавленную книгу
     */
    BookDto addBook(BookDto bookDto);

    /**
     * Возвращает книгу по первичному ключу
     *
     * @param id
     * @return книгу по пк
     */
    BookDto getBookByPK(UUID id);

    /**
     * Удаляет книгу по первичному ключу
     *
     * @param id
     * @return удаленную книгу
     */
    BookDto deleteBookByPK(UUID id);

    /**
     * Обновляет книгу
     *
     * @param bookDto
     * @return обновленную книгу
     */
    BookDto updateBook(BookDto bookDto);

    /**
     * Возвращает список всех книг
     *
     * @return список всех книг
     */
    List<BookDto> getAllBooks();

    /**
     * Возвращает список книг с пагинизацией и фильрами
     * @param bookSearchDto
     * @return
     */
    PageDto<BookDto> getBooks(Search<BookSearchDto> bookSearchDto);
}
