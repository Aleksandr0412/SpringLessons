package com.aleksandr0412.bookstore.dao.springJdbc.impl;

import com.aleksandr0412.bookstore.dao.springJdbc.OrderJdbcDAO;
import com.aleksandr0412.bookstore.dao.springJdbc.mapper.OrderRowMapper;
import com.aleksandr0412.bookstore.model.Order;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
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

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public OrderJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, SimpleJdbcInsert simpleJdbcInsert, SimpleJdbcCall simpleJdbcCall) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("orders");
    }

    @Override
    //TODO magic
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
//TODO magic
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setObject(1, keysOfBooks.get(i));
                ps.setObject(2, orderId);
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

    //TODO check
    @Override
    public List<UUID> getBooksFromOrder(UUID key) {
        return jdbcTemplate.queryForList("SELECT * FROM book_order WHERE order_id = ?",
                new Object[]{key},
                UUID.class);
    }

    @Override
    public int deleteByPK(UUID key) {
        return jdbcTemplate.update(DELETE_FROM_ORDERS, key);
    }

    //TODO
    @Override
    public int update(Order ob) {
        throw new UnsupportedOperationException();
    }

    //TODO
    @Override
    public Collection<Order> getAll() {
        return null;
    }
}
