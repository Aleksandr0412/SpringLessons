package com.aleksandr0412.bookstore;

import com.aleksandr0412.bookstore.config.SpringConfig;
import com.aleksandr0412.bookstore.model.Author;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.model.User;
import com.aleksandr0412.bookstore.service.AuthorService;
import com.aleksandr0412.bookstore.service.BookService;
import com.aleksandr0412.bookstore.service.OrderService;
import com.aleksandr0412.bookstore.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Book book = new Book();
        book.setId(1L);
        book.setTitle("LOTR1");

        Author author = new Author();
        author.setId(1L);
        author.setName("TOLKIEN");

        User user = new User();
        user.setId(1L);
        user.setUsername("aleksandr");

        Order order = new Order();
        order.setId(1L);
        order.setUser(user);

        BookService bookService = (BookService) context.getBean("bookService");
        AuthorService authorService = (AuthorService) context.getBean("authorService");
        UserService userService = (UserService) context.getBean("userService");
        OrderService orderService = (OrderService) context.getBean("orderService");

        System.out.println(bookService.addBook(book));
        System.out.println(bookService.getAllBooks());
        System.out.println(bookService.deleteBookByPK(1L));

        System.out.println(authorService.addAuthor(author));
        System.out.println(authorService.getAllAuthors());
        System.out.println(authorService.deleteAuthorByPK(1L));

        System.out.println(userService.createUser(user));
        System.out.println(userService.getUserByPK(1L));
        System.out.println(userService.deleteUserByPK(1L));

        System.out.println(orderService.createNewOrder(order));

        System.out.println(bookService.deleteBookByPK(2L));
    }
}
