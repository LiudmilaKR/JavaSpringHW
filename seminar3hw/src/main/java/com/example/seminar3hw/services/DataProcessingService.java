package com.example.seminar3hw.services;

import com.example.seminar3hw.domain.User;
import com.example.seminar3hw.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * класс DataProcessingService сервис взаимодействия с базой данных (репо) пользователей
 */
@Service
public class DataProcessingService {

    /**
     * база данных (репо) пользователей
     */
    @Autowired
    private UserRepository repository;

    /**
     * метод получения списка пользователей из репо
     * @return список пользователей
     */
    public List<User> getAllUsers() {
        return repository.getUsers();
    }

    /**
     * метод добавления пользователя в репо
     * @param user пользователь, которого добавляем
     */
    public void addUserToRepo(User user) {
        repository.addUserToRepo(user);
    }

    /**
     * метод сортировки списка пользователей в репо
     * @param userList список пользователей
     * @return список пользователей
     */
    public List<User> sortUsersByAge(List<User> userList) {
        return userList.stream().sorted(Comparator.comparing(User::getAge)).toList();
    }

    /**
     * метод фильтрации списка пользователей в репо
     * @param userList список пользователей
     * @param age возраст, по которому фильтруются пользователи
     * @return список пользователей
     */
    public List<User> filterUserByAge(List<User> userList, int age) {
        return userList.stream().filter(user -> user.getAge() > age).toList();
    }

    /**
     * метод вычисления сренего возраста пользователей в списке
     * @param userList список пользователей
     * @return список пользователей
     */
    public double calculateAverageAge(List<User> userList) {
        return userList.stream().mapToInt(User::getAge).average().orElse(0);
    }
}
