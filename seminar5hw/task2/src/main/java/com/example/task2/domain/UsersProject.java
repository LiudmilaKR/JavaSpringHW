package com.example.task2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс пользователи проекта
 */
@Entity
@Data
@Table(name = "users_project")
@NoArgsConstructor
@AllArgsConstructor
public class UsersProject extends EntityWithRelation{

    /**
     * Поле id таблицы users_project
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    /**
     * Поле относящийся к проекту пользователь (из таблицы users)
     */
    @OneToOne
    @JoinColumn(name = "related_user_id")
    private User relatedUserId;

    /**
     * Поле относящийся к пользователю проект (из таблицы projects)
     */
    @OneToOne
    @JoinColumn(name = "related_project_id")
    private Project relatedProjectId;
}
