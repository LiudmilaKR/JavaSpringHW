package com.example.task1.repositories;

import com.example.task1.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс TaskRepository доступа к базе данных
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
