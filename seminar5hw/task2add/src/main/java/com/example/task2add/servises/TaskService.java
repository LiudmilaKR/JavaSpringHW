package com.example.task2add.servises;

import com.example.task2add.models.Task;
import com.example.task2add.models.TaskStatus;
import com.example.task2add.models.User;
import com.example.task2add.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    public final TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public void create(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    public void taskInsert(String title, String description, int id) {
        taskRepository.insertTask(title, description, id);
    }

    public List<Task> getByTitle(String title) {
        return taskRepository.getByTitle(title);
    }

    public List<Task> getByStatus(TaskStatus taskStatus) {
        return taskRepository.getByTaskStatus(taskStatus);
    }

    public void delTask(Task task) {
        taskRepository.delete(task);
    }

    public void delTask(int id) {
        taskRepository.delete(getById(id));
    }

    public Task getById(int id) {
        return taskRepository.getById(id);
    }

    public void updateTask(Task task) {
        taskRepository.updateTask(task.getTitle(), task.getDescription(),
                task.getTaskStatus(), task.getId());
    }

    public void updateTask(int id, String title, String desc) {
        Task task = taskRepository.getById(id);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(desc);
            taskRepository.save(task);
        } else {
            throw new RuntimeException("error");
        }
    }

    public void updateStatusById(int id, TaskStatus taskStatus) {
        Task task = getById(id);
        task.setTaskStatus(taskStatus);
        updateTask(task);
    }
}
