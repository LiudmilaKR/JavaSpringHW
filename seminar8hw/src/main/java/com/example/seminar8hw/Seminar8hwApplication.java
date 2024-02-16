package com.example.seminar8hw;

import com.example.seminar8hw.services.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Seminar8hwApplication {

	public static void main(String[] args) {
		SpringApplication.run(Seminar8hwApplication.class, args);

//		var c = new AnnotationConfigApplicationContext(Seminar8hwApplication.class);
//		var service = c.getBean(NoteService.class);
//		service.getAllNotes();
	}

}
