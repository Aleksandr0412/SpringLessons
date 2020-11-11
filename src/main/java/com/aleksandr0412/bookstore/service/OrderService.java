package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.controller.dto.OrderDto;
import com.aleksandr0412.bookstore.model.Order;

/**
 * OrderSetrvice
 */
public interface OrderService {
    /**
     * Создает новый заказ
     *
     * @param orderDto
     * @return созданный заказ
     */
    OrderDto createNewOrder(OrderDto orderDto);
}
