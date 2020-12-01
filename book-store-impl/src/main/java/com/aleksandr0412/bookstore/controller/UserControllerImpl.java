package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.UserController;
import com.aleksandr0412.api.dto.UserDto;
import com.aleksandr0412.bookstore.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserControllerImpl implements UserController {
    private final UserService service;

    public UserControllerImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserDto getUserByPK(UUID id) {
        return service.getUserByPK(id);
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto, UriComponentsBuilder componentsBuilder) {
        UserDto result = service.createUser(userDto);
        URI uri = componentsBuilder.path("/api/book/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @Override
    public UserDto deleteUser(UUID id) {
        return service.deleteUserByPK(id);
    }
}
