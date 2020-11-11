package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.bookstore.controller.dto.UserDto;
import com.aleksandr0412.bookstore.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public UserDto getUserByPK(@PathVariable Long id) {
        return service.getUserByPK(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return service.createUser(userDto);
    }

    @DeleteMapping
    public UserDto deleteUser(@RequestParam(value = "id") Long id) {
        return service.deleteUserByPK(id);
    }
}
