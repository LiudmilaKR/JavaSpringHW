package com.example.noteService.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Класс Note - заметка
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note {

    /**
     * Поле id заметки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    @Column(name = "creation_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate creationDate;
}
