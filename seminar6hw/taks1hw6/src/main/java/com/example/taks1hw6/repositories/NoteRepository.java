package com.example.taks1hw6.repositories;

import com.example.taks1hw6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс взаимодействия с базой данных
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
}
