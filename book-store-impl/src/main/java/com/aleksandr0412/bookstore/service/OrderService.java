package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.order.OrderDto;
import com.aleksandr0412.api.dto.order.OrderSearchDto;

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

    /**
     *
     * @param orderSearchDto
     * @return
     */
    PageDto<OrderDto> getOrders(Search<OrderSearchDto> orderSearchDto);
}
