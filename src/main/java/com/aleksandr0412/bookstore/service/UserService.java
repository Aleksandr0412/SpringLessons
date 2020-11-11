package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.controller.dto.UserDto;
import com.aleksandr0412.bookstore.model.User;

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
    UserDto getUserByPK(Long id);

    /**
     * Удаляет пользователя по первичному ключу
     *
     * @param id
     * @return удаленного пользователя
     */
    UserDto deleteUserByPK(Long id);
}
