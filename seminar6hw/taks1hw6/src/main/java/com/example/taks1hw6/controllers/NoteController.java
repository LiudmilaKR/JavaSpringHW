package com.example.taks1hw6.controllers;

import com.example.taks1hw6.model.Note;
import com.example.taks1hw6.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Класс NoteController обрабатывает http запросы
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    /**
     * Поле взаимодействия с базой данных
     */
    private final NoteRepository noteRepository;

    /**
     * Метод создания заметки
     * @param note создаваемая заметка
     * @return созданная заметка
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        note.setCreationDate(LocalDateTime.now());
        return new ResponseEntity<>(noteRepository.save(note), HttpStatus.CREATED);
    }

    /**
     * Метод просмотра всех заметок
     * @return список всех заметок
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Метод получения заметки по id
     * @param id заметки, которую ищем
     * @return найденная заметка или ошибка 404Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return new ResponseEntity<>(note.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Метод редактирования заметки по id
     * @param initNote заметка для редактирования
     * @param id редактируемой заметки
     * @return отредактированная заметка или ошибка 404Not Found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNoteById (@RequestBody Note initNote, @PathVariable Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            Note newNote = note.get();
            newNote.setTitle(initNote.getTitle());
            newNote.setBody(initNote.getBody());
            return new ResponseEntity<>(noteRepository.save(newNote), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Метод удаления заметки по id
     * @param id заметки для удаления
     * @return статус 200OK или ошибка 404Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById (@PathVariable Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            noteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
