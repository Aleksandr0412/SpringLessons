package com.aleksandr0412.bookstore.dao.map.impl;

import com.aleksandr0412.bookstore.dao.map.UserDAO;
import com.aleksandr0412.bookstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class UserDAOImpl extends AbstractDao<User, UUID> implements UserDAO {
    public UserDAOImpl() {
        super(User.class, new HashMap<>());
    }
}
