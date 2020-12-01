package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.OrderController;
import com.aleksandr0412.api.dto.OrderDto;
import com.aleksandr0412.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("api/order")
public class OrderControllerImpl implements OrderController {
    private final OrderService service;

    public OrderControllerImpl(OrderService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    @Override
    public OrderDto getByPK(@PathVariable UUID id) {
        return service.getOrderByPk(id);
    }

    @PostMapping
    @Override
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto, UriComponentsBuilder componentsBuilder) {
        OrderDto result = service.createNewOrder(orderDto);
        URI uri = componentsBuilder.path("/api/order/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

}
