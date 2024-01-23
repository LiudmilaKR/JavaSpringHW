package com.example.seminar2HW.service;

import com.example.seminar2HW.model.User;
import com.example.seminar2HW.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс UserService собирает всю логику работы с юзерами
 */
@Service
public class UserService {
    /**
     * Поле репозитория
     */
    private final UserRepository userRepository;

    /**
     * Конструктор
     * @param userRepository используемый репозиторий
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Метод получения всех пользователей из базы данных
     * @return список всех пользователей
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Метод добавления пользователя в базу данных
     * @param user пользователь, которого добавляем в базу данных
     * @return пользователь, которого добавляем в базу данных
     */
    public User saveUser(User user) {
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
     * @param user пользователь, которого меняем
     * @return пользователь, которого меняем
     */
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }
}
