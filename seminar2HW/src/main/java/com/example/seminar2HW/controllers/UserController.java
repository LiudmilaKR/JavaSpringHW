package com.example.seminar2HW.controllers;

import com.example.seminar2HW.model.User;
import com.example.seminar2HW.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс UserController взаимодейтсвует с браузером
 */
@Controller
public class UserController {
    /**
     * Поле работы с пользователями
     */
    private final UserService userService;

    /**
     * Конструктор
     * @param userService класс работы с пользователями
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Удаление пользователя
     * @param id идентификатор пользователя
     * @return перенаправление на страницу со списком пользователей
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    /**
     * Изменение данных пользователя
     * @param id идентификатор пользователя
     * @param model модель для передачи данных в представление
     * @return представление для изменённых данных
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
//    public String updateUser(@ModelAttribute("user") User user) {
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

}
