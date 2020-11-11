package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.UserDto;
import com.aleksandr0412.bookstore.dao.UserDAO;
import com.aleksandr0412.bookstore.model.User;
import com.aleksandr0412.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDto createUser(UserDto userDto) {
        User user = new User(userDto.getId(), userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
        userDAO.save(user);
        return userDto;
    }

    public UserDto getUserByPK(Long id) {
        User user = userDAO.getByPK(id);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }

    public UserDto deleteUserByPK(Long id) {
        User user = userDAO.deleteByPK(id);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }
}
