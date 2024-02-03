package com.example.task1.services;

import com.example.task1.domain.Task;
import com.example.task1.domain.TaskStatus;
import com.example.task1.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Класс TaskService севис взаимодействий с базой данных
 */
@Service
@AllArgsConstructor
public class TaskService {

    /**
     * Поле доступа к базе данных
     */
    private TaskRepository taskRepository;

    /**
     * Метод просмотра всех задач
     * @return список всех задач
     */
    public List<Task> getAllTasks() {
        System.out.println(LocalDateTime.now());
        return taskRepository.findAll();
    }

    /**
     * Метод добавления задачи
     * @param task задача, которую добавляем
     * @return задача, которую добавили
     */
    public Task addTask(Task task) {
        task.setStatus(TaskStatus.NOT_STARTED);
//        task.setCreationDate(LocalDateTime.parse(LocalDateTime.now()
//                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        task.setCreationDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    /**
     * Метод получения списка задач со статусом status
     * @param taskStatus статус задачи
     * @return список задач со статусом status
     */
    public List<Task> getTasksByStatus(TaskStatus taskStatus) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getStatus().equals(taskStatus))
                .collect(Collectors.toList());
    }

    /**
     * Метод поиска задачи с определенным id
     * @param id задачи, которую ищем
     * @return найденная задача
     */
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    /**
     * Метод удаления задачи по id
     * @param id задачи, которую необходимо удалить
     */
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Метод изменения статуса задачи
     * @param id задачи, которую меняем
     * @param detailedTask задача, которую меняем
     * @return измененную задача
     */
    public Task updateTaskStatus (Long id, Task detailedTask) {
        Optional<Task> foundTask = taskRepository.findById(id);
        if (foundTask.isPresent()) {
            Task task = foundTask.get();
            task.setStatus(detailedTask.getStatus());
            return taskRepository.save(task);
        } else throw new IllegalArgumentException("Задача с id=" + id + " не найдена!");
    }
}
