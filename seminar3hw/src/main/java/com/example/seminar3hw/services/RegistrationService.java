package com.example.seminar3hw.services;

import com.example.seminar3hw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс RegistrationService сервис регистрации действий с пользователями в приложении
 */
@Service
public class RegistrationService {

    /**
     * сервис взаимодействия с базой данных (репо)
     */
    @Autowired
    private DataProcessingService dataProcessingService;
    /**
     * сервис действий с пользователями
     */
    @Autowired
    private UserService userService;
    /**
     * сервис извещений
     */
    @Autowired
    private NotificationService notificationService;

//
//    public DataProcessingService getDataProcessingService() {
//        return dataProcessingService;
//    }

    /**
     * метод получения списка пользователей из репо
     * @return список пользователей
     */
    public List<User> listAllUsers() {
        return dataProcessingService.getAllUsers();
    }

    /**
     * метод добавления пользователя в репо
     * @param user пользователь, которого добавляем
     */
    public void addUser(User user) {
        dataProcessingService.addUserToRepo(user);
    }

    /**
     * метод добавления пользователя в репо
     * @param name имя добавляемого пользователя
     * @param age возвраст добавляемого пользователя
     * @param email адрес добавляемого пользователя
     */
    public void processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
//        dataProcessingService.getRepository()
        dataProcessingService.addUserToRepo(newUser);
        notificationService.notifyUser(newUser);
    }
}
