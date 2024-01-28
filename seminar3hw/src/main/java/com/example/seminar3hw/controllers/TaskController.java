package com.example.seminar3hw.controllers;

import com.example.seminar3hw.domain.User;
import com.example.seminar3hw.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * класс TaskController является контроллером и обрабатывает http-запросы по задачам
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * сервис взаимодействия с базой данных (репо) пользователей
     */
    @Autowired
    private DataProcessingService dataProcessingService;

    /**
     * метод формирования списка доступных задач
     * @return список доступных задач
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUserByAge() {
        return dataProcessingService.sortUsersByAge(dataProcessingService.getAllUsers());
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge(@PathVariable int age) {
        return dataProcessingService.filterUserByAge(dataProcessingService.getAllUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge(dataProcessingService.getAllUsers());
    }
}
