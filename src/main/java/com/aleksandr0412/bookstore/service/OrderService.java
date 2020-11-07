package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.dao.OrderDAO;
import com.aleksandr0412.bookstore.model.Order;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order createNewOrder(Order order) {
        return orderDAO.save(order);
    }
}
