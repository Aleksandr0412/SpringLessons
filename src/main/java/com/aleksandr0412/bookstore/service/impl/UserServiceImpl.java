package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.bookstore.controller.dto.UserDto;
import com.aleksandr0412.bookstore.dao.springJdbc.UserJdbcDAO;
import com.aleksandr0412.bookstore.model.User;
import com.aleksandr0412.bookstore.service.UserService;
import com.aleksandr0412.bookstore.validator.UserDtoValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserJdbcDAO userDAO;
    private final UserDtoValidator validator;

    public UserServiceImpl(UserJdbcDAO userDAO, UserDtoValidator validator) {
        this.userDAO = userDAO;
        this.validator = validator;
    }

    @Transactional
    public UserDto createUser(UserDto userDto) {
        validator.validate(userDto);

        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
        userDAO.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Transactional(readOnly = true)
    public UserDto getUserByPK(UUID id) {
        User user = userDAO.getByPK(id);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }

    @Transactional
    public UserDto deleteUserByPK(UUID id) {
        User user = userDAO.getByPK(id);
        userDAO.deleteByPK(id);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }
}
