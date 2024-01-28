package com.example.seminar3hw.repositories;

import com.example.seminar3hw.domain.User;

import java.util.List;

/**
 * Интерфейс UserRepository - для работы с различными базами пользователей (репо)
 */
public interface UserRepository {
    /**
     * метод получения всех пользователей из репо
     * @return список пользователей
     */
    List<User> getUsers();

    /**
     * метод добавления пользователя в репо
     * @param user пользователь, которого необходимо добавить
     */
    void addUserToRepo(User user);
}
