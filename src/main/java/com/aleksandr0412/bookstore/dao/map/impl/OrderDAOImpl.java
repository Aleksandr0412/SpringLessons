package com.aleksandr0412.bookstore.dao.map.impl;

import com.aleksandr0412.bookstore.dao.map.OrderDAO;
import com.aleksandr0412.bookstore.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class OrderDAOImpl extends AbstractDao<Order, UUID> implements OrderDAO {
    public OrderDAOImpl() {
        super(Order.class, new HashMap<>());
    }
}
