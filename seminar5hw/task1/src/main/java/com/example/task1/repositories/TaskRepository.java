package com.example.task1.repositories;

import com.example.task1.domain.Task;
import com.example.task1.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс TaskRepository доступа к базе данных
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /*
     * Решение от коллеги
     * Получает задачи по статусу
     * Добавлен метод, которого нет в репозитории
    List<Task> findByStatus(TaskStatus status);
    * И у него, как и у лектора, отсутствует аннотация @Repository
     */
}
