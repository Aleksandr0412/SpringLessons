package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.bookstore.controller.dto.OrderDto;
import com.aleksandr0412.bookstore.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return service.createNewOrder(orderDto);
    }
}
