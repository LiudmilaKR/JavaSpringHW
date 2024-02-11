package com.example.task1hw6add.services;

import com.example.task1hw6add.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note createNote(Note note);
    Note updateNote(Note note);
    void deleteNote(Long id);
    List<Note> getNotesByTitleContaining(String keyword);
    List<Note> getNotesByContentContaining(String author);
    List<Note> getNotesByTitleAndContentContaining(String keywordTitle, String keywordContent);
}
