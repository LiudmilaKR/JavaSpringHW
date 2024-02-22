package com.example.seminar10hw;

import com.example.seminar10hw.model.Note;
import com.example.seminar10hw.repositories.NoteRepository;
import com.example.seminar10hw.services.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class NoteServiceIntegrationTests {

	/**
	 * мок-объект репозиторий
	 */
	@MockBean
	private NoteRepository noteRepository;

	@Autowired
	private NoteService noteService;

	private Note note;

	@BeforeEach
	void setUp() {
		Note note = new Note();
		note.setId(1);
		note.setTitle("Заметка");
		note.setBody("test");
		note.setCreationDate(LocalDate.now());
	}

	@Test
	void addNoteTest() {
// предпосылки
		given(noteRepository.save(note)).willReturn((Note) note);
//  action - вызов метода
		noteService.addNote(new Note(1, "Заметка", "test", LocalDate.now()));
//  проверка
		verify(noteRepository).save(new Note(1, "Заметка", "test", LocalDate.now()));
	}

	@Test
	void getAllNotesTest() {
// предпосылки
		List<Note> noteList = new ArrayList<>();
		noteList.add(note);
//  action - вызов метода
		when(noteRepository.findAll()).thenReturn(noteList);
//  проверка
		assertEquals(noteService.getAllNotes(), noteList);
	}

}
