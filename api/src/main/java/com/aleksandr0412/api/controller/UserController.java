package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 *
 */
public interface UserController {
    /**
     * @param id
     * @return пользователя по пк
     */
    @GetMapping("{id}")
    UserDto getUserByPK(@PathVariable UUID id);

    /**
     * @param userDto
     * @param componentsBuilder
     * @return созданного пользователя
     */
    @PostMapping
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto, UriComponentsBuilder componentsBuilder);

    /**
     * @param id
     * @return удаленного пользователя
     */
    @DeleteMapping
    UserDto deleteUser(@RequestParam(value = "id") UUID id);
}
