package com.aleksandr0412.bookstore.config;

import com.aleksandr0412.api.dto.author.AuthorDto;
import com.aleksandr0412.api.dto.book.BookDto;
import com.aleksandr0412.api.dto.order.OrderDto;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.model.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext.Factory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

@Configuration
public class MapperConfig implements OrikaMapperFactoryConfigurer {

    @Bean
    DatatypeFactory datatypeFactory() throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance();
    }

    @Bean
    Factory mappingFactory() {
        var factory = new Factory();
        new DefaultMapperFactory.Builder().mappingContextFactory(factory).build();
        return factory;
    }

    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(Author.class, AuthorDto.class)
                .byDefault()
                .register();

        orikaMapperFactory.classMap(User.class, AuthorDto.class)
                .byDefault()
                .register();

        orikaMapperFactory.classMap(Book.class, BookDto.class)
                .field("author.id", "authorId")
                .byDefault()
                .register();

        orikaMapperFactory.classMap(Order.class, OrderDto.class)
                .field("user.id", "userId")
                .field("books{id}", "bookIds{}")
                .byDefault()
                .register();

    }
}