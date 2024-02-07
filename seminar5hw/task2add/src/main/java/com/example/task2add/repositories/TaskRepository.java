package com.example.task2add.repositories;

import com.example.task2add.models.Task;
import com.example.task2add.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    //    Собственный метод для поиска по названию задачи
    List<Task> getByTitle(String title);

//    Получить задачу по статусу выполнения
    List<Task> getByTaskStatus(TaskStatus taskStatus);

    Task getById(int id);

//    Кастомный запрос
    @Modifying
    @Transactional
    @Query("UPDATE tasks SET title=:title, description=:description, taskStatus=:taskStatus WHERE id=:id")
    void updateTask(String title, String description, TaskStatus taskStatus, int id);

//    Кастомный запрос на создание новой задачи
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tasks VALUES (DEFAULT, :title, " +
            ":description, 'TO_DO', CURRENT_TIMESTAMP, :id)", nativeQuery = true)
    void insertTask(@Param("title") String title, @Param("description") String description, @Param("id") int id);
}
