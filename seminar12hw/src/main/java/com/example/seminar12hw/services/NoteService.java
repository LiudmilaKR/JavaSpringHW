package com.example.seminar12hw.services;

import com.example.seminar12hw.model.Note;
import com.example.seminar12hw.model.exceptions.ResourceNotFoundException;
import com.example.seminar12hw.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
     * Логер
     */
    private Logger logger;

    /**
     * Метод получения всех заметок
     * @return список всех заметок в бд
     */
    public List<Note> getAllNotes() {
        logger.log(LocalDateTime.now() + " Getting all available notes");
        return noteRepository.findAll();
    }

    /**
     * Метод добавления заметки в бд
     * @param note создаваемая заметка
     * @return созданная заметка
     */
    public Note addNote(Note note) {
        note.setCreationDate(LocalDate.now());
        logger.log(LocalDateTime.now() + " Adding note to the db 'notes'");
        return noteRepository.save(note);
    }

    /**
     * Метод получения заметки по идентификатору
     * @param id искомой заметки
     * @return объект заметки или генерация исключения
     */
    public Note findNoteById(long id) {
        logger.log(LocalDateTime.now() + " Getting note by id from the db 'notes'");
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
        logger.log(LocalDateTime.now() + " Deleting not by id from the db 'notes'");
        noteRepository.deleteById(id);
    }
}
