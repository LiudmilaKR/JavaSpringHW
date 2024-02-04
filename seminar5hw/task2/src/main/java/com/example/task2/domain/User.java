package com.example.task2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс User - пользователь
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    /**
     * Поле id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    /**
     * Поле имя пользователя
     */
    @Column(name = "user_name", nullable = false)
    private String userName;
    /**
     * Поле пароль пользователя
     */
    @Column(nullable = false)
    private String password;
    /**
     * Поле почта пользователя
     */
    @Column(nullable = false)
    private String email;
    /**
     * Поле роль пользователя
     */
    @Column(nullable = false)
    private String role;
}
