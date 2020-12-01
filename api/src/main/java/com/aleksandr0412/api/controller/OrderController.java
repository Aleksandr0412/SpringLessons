package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * com.aleksandr0412.bookstore.controller.controller.OrderController
 */
public interface OrderController {
    /**
     * @param id
     * @return закакз по пк
     */
    OrderDto getByPK(UUID id);

    /**
     * @param orderDto
     * @param componentsBuilder
     * @return созданый заказ
     */
    ResponseEntity<OrderDto> createOrder(OrderDto orderDto, UriComponentsBuilder componentsBuilder);
}
