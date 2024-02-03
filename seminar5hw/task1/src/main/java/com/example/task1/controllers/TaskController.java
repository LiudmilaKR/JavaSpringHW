package com.example.task1.controllers;

import com.example.task1.domain.Task;
import com.example.task1.domain.TaskStatus;
import com.example.task1.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс TaskController обрабатывает запросы
 */
@RestController
@AllArgsConstructor
public class TaskController {

    /**
     * Поле сервис работы с задачами
     */
    private TaskService taskService;

    /**
     * Метод получения списка всех задач по адресу http://localhost:8080/tasks
     * @return список всех задач
     */
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Метод создание новой задачи
     * @param task задача, которую создаем
     * @return созданная задача
     */
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    /**
     * Метод получения списка задач со статусом status по адресу http://localhost:8080/status/status
     * @param status указанный статус
     * @return список задач со статусом status
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    /**
     * Метод удаления задачи по id
     * @param id задачи, которую необходимо удалить
     * @return сообщение об удалении задачи
     */
    @DeleteMapping("/task/{id}")
    public String deleteTaskById(@PathVariable Long id) {
        if (taskService.findTaskById(id).isPresent()) {
            taskService.deleteTaskById(id);
            return "Задача с id=" + id + " удалена.";
        }
        else return "Задачи с id=" + id + " не существует!";
    }

    /**
     * Метод изменения статуса задачи
     * @param id задачи, которую меняем
     * @param task задача, которую меняем
     * @return измененную задача
     */
    @PutMapping("/task/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskStatus(id, task);
    }
}
