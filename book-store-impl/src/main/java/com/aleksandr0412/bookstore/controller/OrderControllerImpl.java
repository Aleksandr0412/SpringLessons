package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.OrderController;
import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.order.OrderDto;
import com.aleksandr0412.api.dto.order.OrderSearchDto;
import com.aleksandr0412.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
public class OrderControllerImpl implements OrderController {
    private final OrderService service;

    public OrderControllerImpl(OrderService service) {
        this.service = service;
    }

    @Override
    public OrderDto getByPK(UUID id) {
        return service.getOrderByPk(id);
    }

    @Override
    public ResponseEntity<OrderDto> createOrder(OrderDto orderDto, UriComponentsBuilder componentsBuilder) {
        OrderDto result = service.createNewOrder(orderDto);
        URI uri = componentsBuilder.path("/api/order/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @Override
    public PageDto<OrderDto> getOrders(@RequestBody Search<OrderSearchDto> orderSearchDto) {
        var result = service.getOrders(orderSearchDto);
        return result;
    }


}
