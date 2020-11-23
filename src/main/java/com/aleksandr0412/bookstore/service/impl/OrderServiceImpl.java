package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.OrderDto;
import com.aleksandr0412.bookstore.dao.map.OrderDAO;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.service.OrderService;
import com.aleksandr0412.bookstore.validator.OrderDtoValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderDtoValidator validator;

    public OrderServiceImpl(OrderDAO orderDAO, OrderDtoValidator validator) {
        this.orderDAO = orderDAO;
        this.validator = validator;
    }

    @Override
    public OrderDto createNewOrder(OrderDto orderDto) {
        validator.validate(orderDto);
        Order order = new Order(orderDto.getId(), orderDto.getUser(), orderDto.getPrice(), orderDto.getBooks());
        orderDAO.save(order);
        return orderDto;
    }

    @Override
    public OrderDto getOrderByPk(UUID id) {
        Order order = orderDAO.getByPK(id);
        return new OrderDto(order.getId(), order.getUser(), order.getPrice(), order.getBooks());
    }
}
