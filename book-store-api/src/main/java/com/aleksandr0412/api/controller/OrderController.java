package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.order.OrderDto;
import com.aleksandr0412.api.dto.order.OrderSearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * OrderController
 */
@RequestMapping("api/order")
@Api(value = "API для работы с заказами")
public interface OrderController {

    @GetMapping("{id}")
    @ApiOperation(value = "Детальная информация по заказу")
    OrderDto getByPK(@ApiParam(value = "Идентификатор заказа", required = true) @PathVariable UUID id);

    @PostMapping
    @ApiOperation(value = "Создание заказа")
    ResponseEntity<OrderDto> createOrder(@ApiParam(value = "ДТО заказа", required = true) @RequestBody OrderDto orderDto, UriComponentsBuilder componentsBuilder);

    @GetMapping
    @ApiOperation(value = "Поиск по заказу")
    PageDto<OrderDto> getOrders(@RequestBody Search<OrderSearchDto> orderSearchDto);
}
