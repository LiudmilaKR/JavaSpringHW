package com.example.seminar12hw.controllers;

import com.example.seminar12hw.model.Note;
import com.example.seminar12hw.model.exceptions.ResourceNotFoundException;
import com.example.seminar12hw.services.NoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс NoteController обрабатывает http запросы
 */
//@Slf4j
@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {


    /**
     * Сервис обработки заметок
     */
    private NoteService noteService;

    /**
     * Метод получения всех заметок
     * @return ответ со списком всех заметок в бд
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok().body(noteService.getAllNotes());
    }

    /**
     * Метод добавления заметки в бд
     * @param note создаваемая заметка
     * @return ответ с сохраненной в бд заметкой
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }

    /**
     * Метод получения заметки по идентификатору
     * @param id получаемой заметки
     * @return ответ с заметкой
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable long id) {
        return ResponseEntity.ok().body(noteService.findNoteById(id));
    }

    /**
     * Метод удаления заметки по идентификатору
     * @param id удаляемой заметки
     * @return ответ об удалении заметки
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable long id) {
        try {
            noteService.deleteNote(id);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
