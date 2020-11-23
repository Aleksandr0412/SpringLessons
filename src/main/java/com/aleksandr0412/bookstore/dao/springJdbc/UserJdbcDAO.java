package com.aleksandr0412.bookstore.dao.springJdbc;

import com.aleksandr0412.bookstore.model.User;

import java.util.UUID;

public interface UserJdbcDAO extends GenericJdbcDAO<User, UUID> {
}
