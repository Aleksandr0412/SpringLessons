package com.aleksandr0412.bookstore.dao.springJdbc;

import com.aleksandr0412.bookstore.model.Order;

import java.util.List;
import java.util.UUID;

public interface OrderJdbcDAO extends GenericJdbcDAO<Order, UUID> {
    int[] saveBooksInOrder(UUID orderId, List<UUID> keysOfBooks);

    List<UUID> getBooksFromOrder(UUID key);
}
