package com.example.seminar3hw.repositories;

import com.example.seminar3hw.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryH2 {

    /**
     * поле для работы с базой донных (объект подключения к БД)
     */
    private final JdbcTemplate jdbc;

    /**
     * Конструктор класса
     * @param jdbc класс для работы с базой донных
     */
    public UserRepositoryH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод получения всех пользователей из базы данных
     * @return список всех пользователей
     */
    public List<User> getU() {
        String sql = "SELECT * FROM userTable";

//  String sql = "SELECT * FROM \"user\""  - код Евгения
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

//    код Евгения
    public void addU(User user) {
        String sql = "INSERT INTO \"user\" (name, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}
