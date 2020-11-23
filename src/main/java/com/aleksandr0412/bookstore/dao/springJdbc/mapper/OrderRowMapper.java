package com.aleksandr0412.bookstore.dao.springJdbc.mapper;

import com.aleksandr0412.bookstore.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static com.aleksandr0412.bookstore.common.JdbcConstants.*;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        final Order order = new Order();
        order.setId(UUID.fromString(resultSet.getString(ORDER_ID)));
        order.setPrice(resultSet.getBigDecimal(ORDER_PRICE));
        return order;
    }
}
