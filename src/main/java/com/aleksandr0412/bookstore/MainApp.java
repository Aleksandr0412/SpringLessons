package com.aleksandr0412.bookstore;

import com.aleksandr0412.bookstore.config.SpringConfig;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.model.User;
import com.aleksandr0412.bookstore.service.impl.AuthorServiceImpl;
import com.aleksandr0412.bookstore.service.impl.BookServiceImpl;
import com.aleksandr0412.bookstore.service.impl.OrderServiceImpl;
import com.aleksandr0412.bookstore.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//
//        Book book = new Book();
//        book.setId(1L);
//        book.setTitle("LOTR1");
//
//        Author author = new Author();
//        author.setId(1L);
//        author.setName("TOLKIEN");
//
//        User user = new User();
//        user.setId(1L);
//        user.setUsername("aleksandr");
//
//        Order order = new Order();
//        order.setId(1L);
//        order.setUser(user);
//
//        BookServiceImpl bookService = (BookServiceImpl) context.getBean("bookServiceImpl");
//        AuthorServiceImpl authorService = (AuthorServiceImpl) context.getBean("authorServiceImpl");
//        UserServiceImpl userService = (UserServiceImpl) context.getBean("userServiceImpl");
//        OrderServiceImpl orderService = (OrderServiceImpl) context.getBean("orderServiceImpl");
//
//        System.out.println(bookService.addBook(book));
//        System.out.println(bookService.getAllBooks());
//        System.out.println(bookService.deleteBookByPK(1L));
//
//        System.out.println(authorService.addAuthor(author));
//        System.out.println(authorService.getAllAuthors());
//        System.out.println(authorService.deleteAuthorByPK(1L));
//
//        System.out.println(userService.createUser(user));
//        System.out.println(userService.getUserByPK(1L));
//        System.out.println(userService.deleteUserByPK(1L));
//
//        System.out.println(orderService.createNewOrder(order));
//
//        System.out.println(bookService.deleteBookByPK(2L));
//    }
}
