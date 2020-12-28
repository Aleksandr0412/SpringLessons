package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.user.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * UserController
 */
@RequestMapping("api/user")
@Api(value = "API для работы с пользователями")
public interface UserController {

    @GetMapping("{id}")
    @ApiOperation(value = "Детальная информация по пользователю")
    UserDto getUserByPK(@PathVariable UUID id);

    @PostMapping
    @ApiOperation(value = "Создание пользователя")
    ResponseEntity<UserDto> createUser(@ApiParam(value = "ДТО заказа", required = true) @RequestBody UserDto userDto, UriComponentsBuilder componentsBuilder);

    @DeleteMapping
    @ApiOperation(value = "Удаление пользователя")
    UserDto deleteUser(@ApiParam(value = "Идентификатор пользователя", required = true) @RequestParam(value = "id") UUID id);
}
