package com.example.task1hw6add.repositories;

import com.example.task1hw6add.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    //    Найти заметку по идентификатору
    Optional<Note> findById(Long id);

//    Найти заметки, у которых заголовок содержит заданное ключевое слово игнорируя регистр.
    List<Note> findByTitleContainingIgnoreCase(String keywordTitle);

//    Найти заметки, у которых содержимое содержит заданное ключевое слово игнорируя регистр.
    List<Note> findNotesByContentContainingIgnoreCase(String keywordContent);

//    Найти заметки, у которых заголовок и содержимое содержат заданные ключевые слова игнорируя регистр.
    List<Note> findByTitleContainingIgnoreCaseAndContentContainingIgnoreCase(
            String keywordTitle, String keywordContent);
}
