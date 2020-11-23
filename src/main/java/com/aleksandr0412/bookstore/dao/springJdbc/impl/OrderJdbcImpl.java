package com.aleksandr0412.bookstore.dao.springJdbc.impl;

import com.aleksandr0412.bookstore.dao.springJdbc.OrderJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.mapper.OrderRowMapper;
import com.aleksandr0412.bookstore.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.aleksandr0412.bookstore.common.JdbcConstants.ORDER_ID;
import static com.aleksandr0412.bookstore.common.JdbcConstants.ORDER_PRICE;
import static com.aleksandr0412.bookstore.common.Queries.DELETE_FROM_ORDERS;
import static com.aleksandr0412.bookstore.common.Queries.SELECT_ORDER_BY_ID;

public class OrderJdbcImpl implements OrderJdbcDAO {
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    public OrderJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, SimpleJdbcInsert simpleJdbcInsert, SimpleJdbcCall simpleJdbcCall) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("orders");
    }

    @Override
    public int save(Order ob) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(ORDER_ID, ob.getId());
        parameters.put(ORDER_PRICE, ob.getPrice());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public Order getByPK(UUID key) {
        return jdbcTemplate.queryForObject(SELECT_ORDER_BY_ID, new Object[]{key}, new OrderRowMapper());
    }

    @Override
    public int deleteByPK(UUID key) {
        return jdbcTemplate.update(DELETE_FROM_ORDERS, key);
    }

    @Override
    public int update(Order ob) {
        return 0;
    }

    @Override
    public Collection<Order> getAll() {
        return null;
    }
}
