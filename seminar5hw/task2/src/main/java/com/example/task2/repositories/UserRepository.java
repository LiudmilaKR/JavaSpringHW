package com.example.task2.repositories;

import com.example.task2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс UserRepository доступа к базе данных users
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
