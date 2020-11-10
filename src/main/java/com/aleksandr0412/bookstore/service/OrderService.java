package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.model.Order;

/**
 * OrderSetrvice
 */
public interface OrderService {
    /**
     * Создает новый заказ
     *
     * @param order
     * @return созданный заказ
     */
    Order createNewOrder(Order order);
}
