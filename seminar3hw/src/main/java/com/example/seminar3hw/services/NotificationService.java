package com.example.seminar3hw.services;

import com.example.seminar3hw.domain.User;
import org.springframework.stereotype.Service;

/**
 * класс NotificationService - извещение о создании пользователя
 */
@Service
public class NotificationService {

    /**
     * метод сообщения о создании пользователя
     * @param user пользователь
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
}
