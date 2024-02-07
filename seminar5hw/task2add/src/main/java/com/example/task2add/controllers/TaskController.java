package com.example.task2add.controllers;

import com.example.task2add.models.Task;
import com.example.task2add.servises.TaskService;
import com.example.task2add.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

//    Дать задачу пользователю
    @PostMapping("/give/{id}")
    public ResponseEntity<Void> giveTask(@RequestBody Task task, @PathVariable("id") int id) {
        taskService.create(task, userService.getById(id));
        return ResponseEntity.ok().build();
    }
}
