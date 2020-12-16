package com.aleksandr0412.bookstore.config.customMappers;

import com.aleksandr0412.api.dto.book.BookDto;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class BookCustomMapper extends CustomMapper<Book, BookDto> {
    @Override
    public void mapAtoB(Book book, BookDto bookDto, MappingContext context) {
        bookDto.setAuthorId(book.getAuthor().getId());
    }

    @Override
    public void mapBtoA(BookDto bookDto, Book book, MappingContext context) {
        Author author = new Author();
        author.setId(bookDto.getAuthorId());
        book.setAuthor(author);
    }
}
