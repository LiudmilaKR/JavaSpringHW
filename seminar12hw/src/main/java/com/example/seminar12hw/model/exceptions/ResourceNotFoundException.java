package com.example.seminar12hw.model.exceptions;

/**
 * Класс ResourceNotFoundException обрабатывает исключения отсутствия данных
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
