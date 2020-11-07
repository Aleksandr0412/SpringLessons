package com.aleksandr0412.bookstore.dao.impl;

import com.aleksandr0412.bookstore.dao.OrderDAO;
import com.aleksandr0412.bookstore.model.Order;

import java.util.HashMap;

public class OrderDAOImpl extends AbstractDao<Order, Long> implements OrderDAO {
    public OrderDAOImpl() {
        super(Order.class, new HashMap<>());
    }
}
