package com.aleksandr0412.bookstore.service.impl;

import com.aleksandr0412.api.dto.user.UserDto;
import com.aleksandr0412.bookstore.dao.repository.UserRepository;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.model.User;
import com.aleksandr0412.bookstore.service.UserService;
import com.aleksandr0412.bookstore.validator.UserDtoValidator;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final UserDtoValidator validator;
    private final MapperFacade mapperFacade;

    public UserServiceImpl(UserRepository userRepo, UserDtoValidator validator, MapperFacade mapperFacade) {
        this.userRepo = userRepo;
        this.validator = validator;
        this.mapperFacade = mapperFacade;
    }

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        validator.validate(userDto);
        return mapperFacade.map(userRepo.save(mapperFacade.map(userDto, User.class)), UserDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto getUserByPK(UUID id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("bad id"));
        return mapperFacade.map(user, UserDto.class);
    }

    @Transactional
    @Override
    public UserDto deleteUserByPK(UUID id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("bad id"));
        userRepo.deleteById(id);
        return mapperFacade.map(user, UserDto.class);
    }
}
