package com.example.noteService.services;

import com.example.noteService.model.Note;
import com.example.noteService.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс NoteService взаимодействия с базой данных
 */
@Service
@AllArgsConstructor
public class NoteService {

    /**
     * Поле взаимодействия с базой данных
     */
    private NoteRepository noteRepository;

    /**
     * Метод просмотра всех заметок
     * @return список всех заметок
     */
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Метод создания заметки
     * @param note создаваемая заметка
     * @return созданная заметка
     */
    public Note addNote(Note note) {
        note.setCreationDate(LocalDate.now());
        return noteRepository.save(note);
    }
}
