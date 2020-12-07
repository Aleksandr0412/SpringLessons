package com.aleksandr0412.bookstore.dao.springJdbc.impl;

import com.aleksandr0412.bookstore.dao.springJdbc.OrderJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.mapper.OrderRowMapper;
import com.aleksandr0412.bookstore.model.Order;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static com.aleksandr0412.bookstore.dao.springJdbc.mapper.OrderRowMapper.*;

@Repository
public class OrderJdbcImpl implements OrderJdbcDAO {
    public static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ?";
    public static final String DELETE_FROM_ORDERS = "DELETE FROM orders WHERE id = ?";
    public static final String UPDATE_ORDERS = "UPDATE orders SET price = ? where id = ?";
    public static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";

    private static final int BOOK_INDEX = 1;
    private static final int ORDER_INDEX = 2;

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public OrderJdbcImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert orderSimpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = orderSimpleJdbcInsert;
    }

    @Override
    public int save(Order ob) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(ORDER_ID, ob.getId());
        parameters.put(ORDER_PRICE, ob.getPrice());
        parameters.put(ORDER_USER_ID, ob.getUser().getId());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public int[] saveBooksInOrder(UUID orderId, List<UUID> keysOfBooks) {
        return jdbcTemplate.batchUpdate("INSERT INTO book_order VALUES(?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setObject(BOOK_INDEX, keysOfBooks.get(i));
                ps.setObject(ORDER_INDEX, orderId);
            }

            @Override
            public int getBatchSize() {
                return keysOfBooks.size();
            }
        });
    }

    @Override
    public Order getByPK(UUID key) {
        return jdbcTemplate.queryForObject(SELECT_ORDER_BY_ID, new Object[]{key}, new OrderRowMapper());
    }

    @Override
    public List<UUID> getBooksFromOrder(UUID key) {
        return jdbcTemplate.queryForList("SELECT book_id FROM book_order WHERE order_id = ?",
                new Object[]{key},
                UUID.class);
    }

    @Override
    public int deleteByPK(UUID key) {
        return jdbcTemplate.update(DELETE_FROM_ORDERS, key);
    }

    @Override
    public int update(Order ob) {
        return jdbcTemplate.update(UPDATE_ORDERS, ob.getPrice(), ob.getId());
    }

    @Override
    public Collection<Order> getAll() {
        return jdbcTemplate.query(SELECT_ALL_ORDERS, new OrderRowMapper());
    }
}
