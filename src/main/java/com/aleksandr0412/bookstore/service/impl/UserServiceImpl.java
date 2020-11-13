package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.UserDto;
import com.aleksandr0412.bookstore.dao.UserDAO;
import com.aleksandr0412.bookstore.model.User;
import com.aleksandr0412.bookstore.service.UserService;
import com.aleksandr0412.bookstore.validator.UserDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private UserDtoValidator validator;

    public UserServiceImpl(UserDAO userDAO, UserDtoValidator validator) {
        this.userDAO = userDAO;
        this.validator = validator;
    }

    public UserDto createUser(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
        userDAO.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    public UserDto getUserByPK(UUID id) {
        User user = userDAO.getByPK(id);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }

    public UserDto deleteUserByPK(UUID id) {
        User user = userDAO.deleteByPK(id);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }
}
