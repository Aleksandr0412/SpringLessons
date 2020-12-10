package com.aleksandr0412.bookstore.dao.repository;

import com.aleksandr0412.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
