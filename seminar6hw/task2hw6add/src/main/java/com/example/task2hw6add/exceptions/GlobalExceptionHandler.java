package com.example.task2hw6add.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//лобальный обработчик исключений для контроллеров
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CharacterNotFoundException.class)
    public String handleCharacterNotFoundException(
            CharacterNotFoundException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "characterNotFound";
    }
}
