package com.aleksandr0412.bookstore.dao.impl;

import com.aleksandr0412.bookstore.model.User;

import java.util.HashMap;

public class UserDAOImpl extends AbstractDao<User, Long> {
    public UserDAOImpl() {
        super(User.class, new HashMap<>());
    }
}
