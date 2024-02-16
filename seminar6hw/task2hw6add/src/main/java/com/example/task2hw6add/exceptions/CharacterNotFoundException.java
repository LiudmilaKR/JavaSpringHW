package com.example.task2hw6add.exceptions;

//Исключение, возникающее при отсутствии информации о персонаже
public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(String message) {
        super(message);
    }
}
