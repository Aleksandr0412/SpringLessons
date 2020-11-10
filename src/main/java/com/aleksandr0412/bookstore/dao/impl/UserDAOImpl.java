package com.aleksandr0412.bookstore.dao.impl;

import com.aleksandr0412.bookstore.dao.UserDAO;
import com.aleksandr0412.bookstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserDAOImpl extends AbstractDao<User, Long> implements UserDAO {
    public UserDAOImpl() {
        super(User.class, new HashMap<>());
    }
}
