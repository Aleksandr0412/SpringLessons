package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.controller.dto.UserDto;

import java.util.UUID;

/**
 * UserService
 */
public interface UserService {
    /**
     * Создает нового пользователя
     *
     * @param userDto
     * @return созданного пользователя
     */
    UserDto createUser(UserDto userDto);

    /**
     * Возвращает пользователя по первичному ключу
     *
     * @param id
     * @return пользователя по пк
     */
    UserDto getUserByPK(UUID id);

    /**
     * Удаляет пользователя по первичному ключу
     *
     * @param id
     * @return удаленного пользователя
     */
    UserDto deleteUserByPK(UUID id);
}
