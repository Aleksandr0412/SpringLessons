package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.dao.OrderDAO;
import com.aleksandr0412.bookstore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order createNewOrder(Order order) {
        return orderDAO.save(order);
    }
}
