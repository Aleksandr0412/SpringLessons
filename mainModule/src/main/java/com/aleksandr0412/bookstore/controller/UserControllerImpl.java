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

    @GetMapping("{id}")
    @Override
    public UserDto getUserByPK(@PathVariable UUID id) {
        return service.getUserByPK(id);
    }

    @PostMapping
    @Override
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto, UriComponentsBuilder componentsBuilder) {
        UserDto result = service.createUser(userDto);
        URI uri = componentsBuilder.path("/api/book/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @DeleteMapping
    @Override
    public UserDto deleteUser(@RequestParam(value = "id") UUID id) {
        return service.deleteUserByPK(id);
    }
}
