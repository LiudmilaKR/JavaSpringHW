package com.example.noteService.controllers;

import com.example.noteService.model.Note;
import com.example.noteService.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс NoteController обрабатывает http запросы
 */
@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

    /**
     * Поле взаимодействия с базой данных
     */
    private NoteService noteService;

    /**
     * Метод просмотра всех заметок
     * @return список всех заметок
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }
}
