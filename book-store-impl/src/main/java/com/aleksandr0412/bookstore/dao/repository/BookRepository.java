package com.aleksandr0412.bookstore.dao.repository;

import com.aleksandr0412.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
