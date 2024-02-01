package com.example.task4.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Класс QueryConfiguration конфигураций запросов к базе данных
 */
@ConfigurationProperties(prefix = "query")
@Data
@AllArgsConstructor
public class QueryConfiguration {

    /**
     * Поле - запрос выбора всех пользователей из базы данных
     */
    private String selectAll;
    /**
     * Поле - запрос добавления пользователя в базу данных
     */
    private String insertUser;
    /**
     * Поле - запрос удаления пользователя из базы данных
     */
    private String deleteUser;
    /**
     * Поле - запрос поиска пользвателя в базе данных по id
     */
    private String selectById;
    /**
     * Поле - запрос изменения данных пользователя с определенным id
     */
    private String updateUser;
}
