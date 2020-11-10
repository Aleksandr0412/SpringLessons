package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.dao.OrderDAO;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order createNewOrder(Order order) {
        return orderDAO.save(order);
    }
}
