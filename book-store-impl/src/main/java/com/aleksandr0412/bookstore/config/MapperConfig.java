package com.aleksandr0412.bookstore.config;

import com.aleksandr0412.api.dto.AuthorDto;
import com.aleksandr0412.api.dto.BookDto;
import com.aleksandr0412.api.dto.OrderDto;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.model.User;
import liquibase.pro.packaged.A;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.MappingContext.Factory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.stream.Collectors;

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
                .exclude("books")
                .byDefault()
                .customize(
                        new CustomMapper<>() {
                            @Override
                            public void mapAtoB(Author author, AuthorDto authorDto, MappingContext context) {
                                authorDto.setBooks(author.getBooks().stream().map(Book::getId).collect(Collectors.toSet()));
                            }
                        }
                )
                .register();

        orikaMapperFactory.classMap(User.class, AuthorDto.class)
                .byDefault()
                .register();

        orikaMapperFactory.classMap(Book.class, BookDto.class)
                .exclude("author")
                .byDefault()
                .customize(
                        new CustomMapper<>() {
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
                )
                .register();


        orikaMapperFactory.classMap(Order.class, OrderDto.class)
                .byDefault()
                .customize(
                        new CustomMapper<>() {
                            @Override
                            public void mapAtoB(Order order, OrderDto orderDto, MappingContext context) {
                                super.mapAtoB(order, orderDto, context);
                                orderDto.setUserId(order.getUser().getId());
                                orderDto.setBookIds(order.getBooks().stream().map(Book::getId).collect(Collectors.toList()));
                            }

                            @Override
                            public void mapBtoA(OrderDto orderDto, Order order, MappingContext context) {
                                super.mapBtoA(orderDto, order, context);
                            }
                        }
                )
                .register();

    }
}