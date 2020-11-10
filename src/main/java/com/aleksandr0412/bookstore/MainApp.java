package com.aleksandr0412.bookstore;

import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        Book book = new Book();
        book.setId(1L);
        book.setTitle("LOTR1");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println(bookService.addBook(book) + "\n\n");
        System.out.println(bookService.getAllBooks());

        //exception
        bookService.deleteBookByPK(2L);

    }
}
