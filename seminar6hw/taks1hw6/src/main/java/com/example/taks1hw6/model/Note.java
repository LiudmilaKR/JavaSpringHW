package com.example.taks1hw6.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Класс Note - заметка
 */
@Data
@Entity
@NoArgsConstructor
public class Note {
    /**
     * Поле id заметки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Поле заголовок заметки
     */
    @Column(nullable = false)
    private String title;
    /**
     * Поле содержимое заметки
     */
    @Column(nullable = false)
    private String body;
    /**
     * Поле дата создания заметки
     */
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}
