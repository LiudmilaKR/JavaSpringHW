package com.example.seminar2HW.controllers;

import com.example.seminar2HW.model.User;
import com.example.seminar2HW.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

//    @GetMapping("/user-update/{user}")
//    public String updateUser(User user) {
//        @PathVariable("id") int id = user.getId();
//        return "/user-update/{user}";
//    }

//    @PostMapping("/user-update")
//    public String updateUser(User user) {
//        userService.updateUser(user);
//        return "redirect:/users";
//    }

}
