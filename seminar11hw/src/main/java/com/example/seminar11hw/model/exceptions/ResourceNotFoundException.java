package com.example.seminar11hw.model.exceptions;

import lombok.AllArgsConstructor;

/**
 * Класс ResourceNotFoundException обрабатывает исключения отсутствия данных
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
