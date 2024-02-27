package com.example.seminar11hw.services;

import com.example.seminar11hw.model.Note;
import com.example.seminar11hw.model.exceptions.ResourceNotFoundException;
import com.example.seminar11hw.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Класс NoteService взаимодействия с базой данных
 */
@Service
@AllArgsConstructor
public class NoteService {

    /**
     * Репозиторий для работы с базой данных заметок
     */
    private NoteRepository noteRepository;

    /**
     * Метод получения всех заметок
     * @return список всех заметок в бд
     */
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Метод добавления заметки в бд
     * @param note создаваемая заметка
     * @return созданная заметка
     */
    public Note addNote(Note note) {
        note.setCreationDate(LocalDate.now());
        return noteRepository.save(note);
    }

    /**
     * Метод получения заметки по идентификатору
     * @param id искомой заметки
     * @return объект заметки или генерация исключения
     */
    public Note findNoteById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Note " + id + " not found!"));
    }

    /**
     * Метод удаления заметки по идентификатору
     * @param id заметки
     * @throws ResourceNotFoundException исключение при отсутствии заметки в бд
     */
    public void deleteNote(long id) throws ResourceNotFoundException {
        findNoteById(id);
        noteRepository.deleteById(id);
    }
}
