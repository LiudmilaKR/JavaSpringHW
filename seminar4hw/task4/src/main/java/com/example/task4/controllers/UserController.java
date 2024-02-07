package com.example.task4.controllers;

import com.example.task4.model.User;
import com.example.task4.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Класс UserController обрабатывает запросы
 */
@Controller
@AllArgsConstructor
@Log
public class UserController {

    /**
     * Поле работы с пользователями
     */
    private UserService userService;

    /**
     * Метод получения списка всех пользователей из базы данных
     * @param model карта, на которую помещаем данные для отображения на html странице
     * @return страница со списком пользователей
     */
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        log.info("Запрос на отображение списка задач.");
        List<User> userList = userService.getAllUsers();
        log.info(String.format("Получено %d задач из базы данных.", userList.size()));
        model.addAttribute("users", userList);
        return "user-list";
    }

    /**
     * Метод создания формы для заполнения полей
     * @param user пользователь, которого планируем создать
     * @return страница с формой для заполнения данных пользователя
     */
    @GetMapping("/user-create")
    public String addUserForm(User user) {
        return "user-create";
    }

    /**
     * Метод добавления пользователя в базу данных
     * @param user пользователь, которого добавляем
     * @return перенаправление на страницу со списком пользователей
     */
    @PostMapping("/user-create")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    /**
     * Метод удаления пользователя из базы данных
     * @param id пользователя для удаления
     * @return перенаправление на страницу со списком пользователей
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable int id, Model model) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    /**
     * Метод создания формы для изменение данных пользователя
     * @param id идентификатор пользователя
     * @param model карта, на которую помещаем данные для отображения на html странице
     * @return страница с формой для изменения данных пользователя
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Метод изменение данных пользователя
     * @param user пользователь, данные которого необходимо изменить
     * @return перенаправление на страницу со списком пользователей
     */
    @PostMapping("user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return  "redirect:/users";
    }
}
