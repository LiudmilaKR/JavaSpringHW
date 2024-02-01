package com.example.task3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс Cat - котик
 */
@Data
@AllArgsConstructor
public class Cat {
    /**
     * Поле номер котика
     */
    private int number;
    /**
     * Поле имя котика
     */
    private String name;
    /**
     * Поле описание котика
     */
    private String description;
}
