package com.example.task2.repositories;

import com.example.task2.domain.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс UsersProjectRepository доступа к базе данных users_project
 */
//@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
}
