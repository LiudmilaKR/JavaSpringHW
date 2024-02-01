package com.example.task4.model;

import lombok.Data;

/**
 * Класс User пользователь
 */
@Data
public class User {
    /**
     * Идентификационный номер пользователя
     */
    private int id;
    /**
     * Имя пользователя
     */
    private String firstName;
    /**
     * Фамилия пользователя
     */
    private String lastName;
}
