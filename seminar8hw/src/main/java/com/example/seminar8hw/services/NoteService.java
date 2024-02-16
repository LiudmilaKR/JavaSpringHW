package com.example.seminar8hw.services;

import com.example.seminar8hw.aspects.TrackUserAction;
import com.example.seminar8hw.model.Note;
import com.example.seminar8hw.repositories.NoteRepository;
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
    @TrackUserAction
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Метод создания заметки
     * @param note создаваемая заметка
     * @return созданная заметка
     */
    @TrackUserAction
    public Note addNote(Note note) {
        note.setCreationDate(LocalDate.now());
        noteRepository.save(note);
        return note;
    }
}
