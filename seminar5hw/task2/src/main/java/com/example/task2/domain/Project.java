package com.example.task2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Класс Project - проект
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {

    /**
     * Поле id проекта
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    /**
     * Поле имя проекта
     */
    @Column(nullable = false)
    private String name;
    /**
     * Поле описание проекта
     */
    @Column(nullable = false)
    private String description;
    /**
     * Поле дата создания проекта
     */
    @Column(name = "created_date")
    private LocalDate createdDate;
}
