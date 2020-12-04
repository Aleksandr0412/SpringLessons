package com.aleksandr0412.bookstore.config.customMappers;

import com.aleksandr0412.api.dto.OrderDto;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.model.User;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

import java.util.stream.Collectors;

public class OrderCustomMapper extends CustomMapper<Order, OrderDto> {
    @Override
    public void mapAtoB(Order order, OrderDto orderDto, MappingContext context) {
        orderDto.setUserId(order.getUser().getId());
        orderDto.setBookIds(order.getBooks().stream().map(Book::getId).collect(Collectors.toList()));
    }

    @Override
    public void mapBtoA(OrderDto orderDto, Order order, MappingContext context) {
        User user = new User();
        user.setId(orderDto.getUserId());
        order.setUser(user);
    }
}
