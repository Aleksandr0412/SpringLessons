package com.aleksandr0412.bookstore.config.customMappers;

import com.aleksandr0412.api.dto.AuthorDto;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

import java.util.stream.Collectors;

public class AuthorCustomMapper extends CustomMapper<Author, AuthorDto> {
    @Override
    public void mapAtoB(Author author, AuthorDto authorDto, MappingContext context) {
        authorDto.setBooks(author.getBooks().stream().map(Book::getId).collect(Collectors.toSet()));
    }
}
