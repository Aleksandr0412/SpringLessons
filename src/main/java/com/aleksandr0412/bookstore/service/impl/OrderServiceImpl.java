package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.OrderDto;
import com.aleksandr0412.bookstore.dao.springJdbc.BookJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.OrderJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.UserJdbcDAO;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.service.OrderService;
import com.aleksandr0412.bookstore.validator.OrderDtoValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderJdbcDAO orderDAO;
    private OrderDtoValidator validator;
    private BookJdbcDAO bookDAO;
    private UserJdbcDAO userDAO;

    public OrderServiceImpl(OrderJdbcDAO orderDAO, OrderDtoValidator validator, BookJdbcDAO bookDAO, UserJdbcDAO userDAO) {
        this.orderDAO = orderDAO;
        this.validator = validator;
        this.bookDAO = bookDAO;
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public OrderDto createNewOrder(OrderDto orderDto) {
        validator.validate(orderDto);
        Order order = new Order(orderDto.getId(), orderDto.getUser(), orderDto.getPrice(), orderDto.getBooks());
        orderDAO.save(order);
        orderDAO.saveBooksInOrder(order.getId(), order.getBooks()
                .stream()
                .map(Book::getId)
                .collect(Collectors.toList()));
        return orderDto;
    }

    @Override
    @Transactional
    public OrderDto getOrderByPk(UUID id) {
        Order order = orderDAO.getByPK(id);
//        List<Book> books = new ArrayList<>();
//        books.addAll(orderDAO.getBooksFromOrder(id).forEach(uuid -> bookDAO.getByPK(uuid)))
        order.setBooks(orderDAO.getBooksFromOrder(id)
                .stream()
                .map(uuid -> bookDAO.getByPK(uuid))
                .collect(Collectors.toList()));
        order.setUser(userDAO.getByPK(order.getUser().getId()));
        return new OrderDto(order.getId(), order.getUser(), order.getPrice(), order.getBooks());
    }
}
