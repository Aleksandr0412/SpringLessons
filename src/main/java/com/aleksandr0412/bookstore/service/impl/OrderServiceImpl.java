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

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderJdbcDAO orderDAO;
    private final OrderDtoValidator validator;
    private final BookJdbcDAO bookDAO;
    private final UserJdbcDAO userDAO;

    public OrderServiceImpl(OrderJdbcDAO orderDAO, OrderDtoValidator validator, BookJdbcDAO bookDAO, UserJdbcDAO userDAO) {
        this.orderDAO = orderDAO;
        this.validator = validator;
        this.bookDAO = bookDAO;
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public OrderDto createNewOrder(OrderDto orderDto) {
        orderDto.setId(UUID.randomUUID());
        validator.validate(orderDto);
        List<Book> books = getBooksByPKList(orderDto.getBookIds());
        Order order = new Order(orderDto.getId(), userDAO.getByPK(orderDto.getUserId()), orderDto.getPrice(), books);
        orderDAO.save(order);
        orderDAO.saveBooksInOrder(order.getId(), getBooksUUID(order.getBooks()));
        return orderDto;
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDto getOrderByPk(UUID id) {
        Order order = orderDAO.getByPK(id);
        order.setBooks(getBooksByPKList(orderDAO.getBooksFromOrder(id)));
        order.setUser(userDAO.getByPK(order.getUser().getId()));
        return new OrderDto(order.getId(), order.getUser().getId(), order.getPrice(), getBooksUUID(order.getBooks()));
    }

    @Transactional(readOnly = true)
    public List<Book> getBooksByPKList(List<UUID> uuids) {
        return uuids.stream()
                .map(bookDAO::getByPK)
                .collect(Collectors.toList());
    }

    private List<UUID> getBooksUUID(List<Book> books) {
        return books.stream()
                .map(Book::getId)
                .collect(Collectors.toList());
    }
}
