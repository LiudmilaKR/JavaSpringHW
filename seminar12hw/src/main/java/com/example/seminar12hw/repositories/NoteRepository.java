package com.example.seminar12hw.repositories;

import com.example.seminar12hw.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс взаимодействия с базой данных
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
}
