package com.example.task2.repositories;

import com.example.task2.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс ProjectRepository доступа к базе данных projects
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
