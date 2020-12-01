package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.controller.dto.OrderDto;

import java.util.UUID;

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

    /**
     * Возвращает заказ по пк
     *
     * @param id
     * @return заказ по первичному ключу
     */
    OrderDto getOrderByPk(UUID id);
}
