package com.aleksandr0412.api.controller;

import com.aleksandr0412.api.dto.UserDto;
import org.springframework.http.ResponseEntity;
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
    UserDto getUserByPK(UUID id);

    /**
     * @param userDto
     * @param componentsBuilder
     * @return созданного пользователя
     */
    ResponseEntity<UserDto> createUser(UserDto userDto, UriComponentsBuilder componentsBuilder);

    /**
     * @param id
     * @return удаленного пользователя
     */
    UserDto deleteUser(UUID id);
}
