package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.dao.UserDAO;
import com.aleksandr0412.bookstore.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User createUser(User user) {
        return userDAO.save(user);
    }

    public User getUserByPK(Long id) {
        return userDAO.getByPK(id);
    }

}
