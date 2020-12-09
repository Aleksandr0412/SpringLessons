package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.OrderDto;
import com.aleksandr0412.bookstore.dao.repository.OrderRepository;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.service.OrderService;
import com.aleksandr0412.bookstore.validator.OrderDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Primary
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepo;
    private final OrderDtoValidator validator;
    private final MapperFacade mapperFacade;

    public OrderServiceImpl(OrderRepository orderRepo, OrderDtoValidator validator, MapperFacade mapperFacade) {
        this.orderRepo = orderRepo;
        this.validator = validator;
        this.mapperFacade = mapperFacade;
    }

    @Transactional
    @Override
    public OrderDto createNewOrder(OrderDto orderDto) {
        validator.validate(orderDto);
        orderRepo.save(mapperFacade.map(orderDto, Order.class));
        return orderDto;
    }

    @Transactional(readOnly = true)
    @Override
    public OrderDto getOrderByPk(UUID id) {
       return mapperFacade.map(orderRepo.findById(id), OrderDto.class);

    }
}
