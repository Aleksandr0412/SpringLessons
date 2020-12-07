package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.UserDto;
import com.aleksandr0412.bookstore.dao.springJdbc.UserJdbcDAO;
import com.aleksandr0412.bookstore.model.User;
import com.aleksandr0412.bookstore.service.UserService;
import com.aleksandr0412.bookstore.validator.UserDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserJdbcDAO userDAO;
    private final UserDtoValidator validator;
    private final MapperFacade mapperFacade;

    public UserServiceImpl(UserJdbcDAO userDAO, UserDtoValidator validator, MapperFacade mapperFacade) {
        this.userDAO = userDAO;
        this.validator = validator;
        this.mapperFacade = mapperFacade;
    }

    @Transactional
    public UserDto createUser(UserDto userDto) {
        validator.validate(userDto);
        userDto.setId(UUID.randomUUID());
        User user = mapperFacade.map(userDto, User.class);
        userDAO.save(user);

        return userDto;
    }

    @Transactional(readOnly = true)
    public UserDto getUserByPK(UUID id) {
        User user = userDAO.getByPK(id);

        return mapperFacade.map(user, UserDto.class);
    }

    @Transactional
    public UserDto deleteUserByPK(UUID id) {
        User user = userDAO.getByPK(id);
        userDAO.deleteByPK(id);

        return mapperFacade.map(user, UserDto.class);
    }
}
