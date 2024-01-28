package com.example.seminar3hw.controllers;

import com.example.seminar3hw.domain.User;
import com.example.seminar3hw.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * класс UserController является контроллером и обрабатывает http-запросы по пользователям
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * сервис действий
     */
    @Autowired
    private RegistrationService service;

    /**
     * метод получения списка пользователей из репо
     * @return список пользователей
     */
    @GetMapping
    public List<User> users() {
//        return service.getDataProcessingService().getRepository().getUsers();
//        return service.getDataProcessingService().getAllUsers();
        return service.listAllUsers();
    }

    /**
     * метод добавления пользователя в репо
     * @param user добавляемый пользователь
     * @return сообщение о добавлении пользователя
     */
    @PostMapping("/body1")
    public String userAddFromBody(@RequestBody User user) {
        service.addUser(user);
        return "User was added from body!";
    }

    /**
     * метод регистрации пользователя в репо
     * @param user добавляемый пользователь
     * @return сообщение о регистрации пользователя
     */
    @PostMapping("/body")
    public String userRegistration(@RequestBody User user) {
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User was registered!";
    }

    /**
     * метод создания пользователя из параметров HTTP запроса
     * @param user добавляемый пользователь
     * @return сообщение о регистрации пользователя
     */
    @PostMapping("/body2")
    public String userAddFromParam(@RequestBody User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail());
        service.addUser(newUser);
        return "User was added!";
    }
}
