package com.example.task2add.controllers;

import com.example.task2add.models.User;
import com.example.task2add.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    Показать всех пользователей
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

//    Создание нового пользователя
    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

//    Обновить пользователя
    @PostMapping("/update-user")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok().build();
    }

//    Удалить пользователя
    public ResponseEntity<Void> deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return ResponseEntity.ok().build();
    }
}
