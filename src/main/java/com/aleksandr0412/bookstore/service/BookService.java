package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.controller.dto.BookDto;

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
}
