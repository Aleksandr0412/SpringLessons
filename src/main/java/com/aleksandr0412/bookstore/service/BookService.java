package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.model.Book;

import java.util.List;

/**
 * BookService
 */
public interface BookService {
    /**
     * Добавляет книгу
     *
     * @param book
     * @return добавленную книгу
     */
    Book addBook(Book book);

    /**
     * Возвращает книгу по первичному ключу
     *
     * @param id
     * @return книгу по пк
     */
    Book getBookByPK(Long id);

    /**
     * Удаляет книгу по первичному ключу
     *
     * @param id
     * @return удаленную книгу
     */
    Book deleteBookByPK(Long id);

    /**
     * Обновляет книгу
     *
     * @param book
     * @return обновленную книгу
     */
    Book updateBook(Book book);

    /**
     * Возвращает список всех книг
     *
     * @return список всех книг
     */
    List<Book> getAllBooks();
}
