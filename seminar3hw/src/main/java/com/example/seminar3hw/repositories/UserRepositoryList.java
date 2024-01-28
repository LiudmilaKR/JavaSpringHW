package com.example.seminar3hw.repositories;

import com.example.seminar3hw.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс UserRepositoryList - работает со списком пользователей
 */
@Component
public class UserRepositoryList implements UserRepository {
    /**
     * список пользователей
     */
    private List<User> users;

    /**
     * конструктор списка пользователей
     */
    public UserRepositoryList() {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setName("Vasiliy");
        user1.setAge(34);
        user1.setEmail("vvv@test.com");
        users.add(user1);
        User user2 = new User();
        user2.setName("Svetlana");
        user2.setAge(31);
        user2.setEmail("sss@test.com");
        users.add(user2);
    }

    /**
     * метод получения списка пользователей
     * @return список пользователей
     */
    @Override
    public List<User> getUsers() {
        return users;
    }

    /**
     * метод добавления пользователя в список
     * @param user пользователь, которого необходимо добавить
     */
    @Override
    public void addUserToRepo(User user) {
        users.add(user);
    }

    /**
     * метод сортировки пользователей в списке
     * @param userList список пользователей
     * @return сортированный список пользователей
     */
    public List<User> sortUsersByAge(List<User> userList) {
        return userList.stream().sorted(Comparator.comparing(User::getAge)).toList();
    }
}
