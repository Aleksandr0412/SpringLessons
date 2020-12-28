package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.order.OrderDto;
import com.aleksandr0412.api.dto.order.OrderSearchDto;
import com.aleksandr0412.bookstore.dao.repository.OrderRepository;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.service.OrderService;
import com.aleksandr0412.bookstore.service.specifications.OrderSpecBuilder;
import com.aleksandr0412.bookstore.validator.OrderDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Primary
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepo;
    private final OrderDtoValidator validator;
    private final MapperFacade mapperFacade;
    private final OrderSpecBuilder orderSpecBuilder;

    public OrderServiceImpl(OrderRepository orderRepo, OrderDtoValidator validator, MapperFacade mapperFacade, OrderSpecBuilder orderSpecBuilder) {
        this.orderRepo = orderRepo;
        this.validator = validator;
        this.mapperFacade = mapperFacade;
        this.orderSpecBuilder = orderSpecBuilder;
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

    @Transactional(readOnly = true)
    @Override
    public List<OrderDto> getAll() {
        return mapperFacade.mapAsList(orderRepo.findAll(), OrderDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public PageDto<OrderDto> getOrders(Search<OrderSearchDto> orderSearchDto) {
        Page<Order> page = orderRepo
                .findAll(orderSpecBuilder.getSpec(orderSearchDto.getData()), getOf(orderSearchDto));
        var orders = page
                .map(order ->
                        mapperFacade.map(order, OrderDto.class)
                )
                .toList();
        return new PageDto<>(orders, page.getTotalElements());

    }

    private PageRequest getOf(Search<OrderSearchDto> orderSearchDto) {
        var page = orderSearchDto.getPage();
        return PageRequest.of(page.getPage(), page.getSize());
    }

}
