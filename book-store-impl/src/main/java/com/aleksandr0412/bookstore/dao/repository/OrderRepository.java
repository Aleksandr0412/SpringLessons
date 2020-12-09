package com.aleksandr0412.bookstore.dao.repository;

import com.aleksandr0412.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
