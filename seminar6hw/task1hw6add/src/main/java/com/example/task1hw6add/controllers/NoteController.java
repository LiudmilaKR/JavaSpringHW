package com.example.task1hw6add.controllers;

import com.example.task1hw6add.model.Note;
import com.example.task1hw6add.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

//    Поиск заметок по ключевым словам в заголовках и содержимом.
//    Если оба ключевых слова не указаны, вернуть все заметки.
    @GetMapping("/search")
    public ResponseEntity<List<Note>> searchNotes(
            @RequestParam(required = false) String keywordContent,
            @RequestParam(required = false) String keywordTitle) {

        if (keywordContent != null && keywordTitle != null) {
            return ResponseEntity.ok(noteService
                    .getNotesByTitleAndContentContaining(keywordTitle, keywordContent));
        } else if (keywordContent != null) {
            return ResponseEntity.ok(noteService.getNotesByContentContaining(keywordContent));
        } else if (keywordTitle != null) {
            return ResponseEntity.ok(noteService.getNotesByTitleContaining(keywordTitle));
        } else return ResponseEntity.ok(noteService.getAllNotes());
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.createNote(note));
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.updateNote(note));
    }

    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
