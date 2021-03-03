package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.OrderController;
import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.order.OrderDto;
import com.aleksandr0412.api.dto.order.OrderSearchDto;
import com.aleksandr0412.bookstore.annotations.Audit;
import com.aleksandr0412.bookstore.constants.AuditCode;
import com.aleksandr0412.bookstore.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
public class OrderControllerImpl implements OrderController {
    private final OrderService service;
    private static final Logger log = LoggerFactory.getLogger(OrderControllerImpl.class.getName());

    public OrderControllerImpl(OrderService service) {
        this.service = service;
    }

    @Override
    public OrderDto getByPK(UUID id) {
        log.info("getOrder with {} - start ", id);
        var result = service.getOrderByPk(id);
        log.info("getOrder end with {}, with result {}", id, result);

        return result;
    }

    @Audit(AuditCode.ORDER_CREATE)
    @Override
    public ResponseEntity<OrderDto> createOrder(OrderDto orderDto, UriComponentsBuilder componentsBuilder) {
        log.info("createOrder with {} - start ", orderDto);
        OrderDto result = service.createNewOrder(orderDto);
        URI uri = componentsBuilder.path("/api/order/" + result.getId()).buildAndExpand(result).toUri();
        log.info("createOrder end with {}, with result {}", orderDto, result);

        return ResponseEntity.created(uri).body(result);
    }

    @Override
    public PageDto<OrderDto> getOrders(@RequestBody Search<OrderSearchDto> orderSearchDto) {
        log.info("getOrder with {} - start ", orderSearchDto);
        var result = service.getOrders(orderSearchDto);
        log.info("getOrder end with {}, with result {}", orderSearchDto, result);

        return result;
    }


}
