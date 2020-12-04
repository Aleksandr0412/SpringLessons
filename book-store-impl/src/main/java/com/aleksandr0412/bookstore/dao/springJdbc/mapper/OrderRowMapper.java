package com.aleksandr0412.bookstore.dao.springJdbc.mapper;

import com.aleksandr0412.bookstore.model.Order;
import com.aleksandr0412.bookstore.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class OrderRowMapper implements RowMapper<Order> {
    public static final String ORDER_ID = "id";
    public static final String ORDER_PRICE = "price";
    public static final String ORDER_USER_ID = "user_id";

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        final Order order = new Order();
        order.setId(UUID.fromString(resultSet.getString(ORDER_ID)));
        order.setPrice(resultSet.getBigDecimal(ORDER_PRICE));
        User user = new User();
        user.setId(UUID.fromString(resultSet.getString(ORDER_USER_ID)));
        order.setUser(user);
        return order;
    }
}
