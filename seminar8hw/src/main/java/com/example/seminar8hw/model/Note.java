package com.example.seminar8hw.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Класс Note - заметка
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notes")
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
    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private LocalDate creationDate;
}
