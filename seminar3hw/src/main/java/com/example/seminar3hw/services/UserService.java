package com.example.seminar3hw.services;

import com.example.seminar3hw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс UserService сервис действий с пользователями
 */
@Service
public class UserService {

    /**
     * метод создания пользователя
     * @param name имя пользователя
     * @param age возраст пользователя
     * @param email адрес пользователя
     * @return созаднного пользователя
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }
}
