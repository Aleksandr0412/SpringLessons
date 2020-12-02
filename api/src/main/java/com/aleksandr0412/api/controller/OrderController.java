package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * OrderController
 */
@RequestMapping("api/order")
public interface OrderController {
    /**
     * @param id
     * @return закакз по пк
     */
    @GetMapping("{id}")
    OrderDto getByPK(@PathVariable UUID id);

    /**
     * @param orderDto
     * @param componentsBuilder
     * @return созданый заказ
     */
    @PostMapping
    ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto, UriComponentsBuilder componentsBuilder);
}
