package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.model.User;

/**
 * UserService
 */
public interface UserService {
    /**
     * Создает нового пользователя
     *
     * @param user
     * @return созданного пользователя
     */
    User createUser(User user);

    /**
     * Возвращает пользователя по первичному ключу
     *
     * @param id
     * @return пользователя по пк
     */
    User getUserByPK(Long id);

    /**
     * Удаляет пользователя по первичному ключу
     *
     * @param id
     * @return удаленного пользователя
     */
    User deleteUserByPK(Long id);
}
