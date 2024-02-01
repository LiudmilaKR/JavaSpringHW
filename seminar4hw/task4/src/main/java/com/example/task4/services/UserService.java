package com.example.task4.services;

import com.example.task4.model.User;
import com.example.task4.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс UserService - севис, который собирает всю логику работы с юзерами
 */
@Service
@AllArgsConstructor
@ToString
public class UserService {

    /**
     * Поле репозитория
     */
    private UserRepository userRepository;

    /**
     * Метод получения всех пользователей из базы данных
     * @return список всех пользователей
     */
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    /**
     * Метод добавления пользователя в базу данных
     * @param user пользователь, которого добавляем в базу данных
     * @return пользователь, которого добавляем в базу данных
     */
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    /**
     * Метод удаления пользователя из базы данных
     * @param id пользователя, которого необходимо удалить из базы данных
     */
    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }

    /**
     * Метод изменения пользователя
     * @param user пользователь с новыми данными
     */
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    /**
     * Метод получения пользователя по id из базы данных
     * @param id пользователя, которого необходимо взять из базы данных
     * @return  искомый пользователь
     */
    public User getUserById(int id) {
        return userRepository.findUserById(id);
    }
}
