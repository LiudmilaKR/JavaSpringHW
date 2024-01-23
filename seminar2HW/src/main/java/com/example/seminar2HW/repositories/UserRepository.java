package com.example.seminar2HW.repositories;

import com.example.seminar2HW.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс UserRepository работает с базой данных
 */
@Repository
public class UserRepository {
    /**
     * поле для работы с базой донных
     */
    private final JdbcTemplate jdbc;

    /**
     * Конструктор
     * @param jdbc класс для работы с базой донных
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод получения всех пользователей из базы данных
     * @return список всех пользователей
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Метод добавления пользователя в базу данных
     * @param user пользователь, которого добавляем в базу данных
     * @return пользователь, которого добавляем в базу данных
     */
    public User addUser(User user) {
        String sql = "INSERT INTO userTable(firstname, lastname) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    /**
     * Метод удаления пользователя из базы данных
     * @param id пользователя, которого необходимо удалить из базы данных
     */
    public void deleteUserById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Метод изменения пользователя
     * @param user пользователь, которого меняем
     * @return пользователь, которого меняем
     */
    public User updateUser(User user) {
        String sql = "UPDATE userTable SET firstName=? lastName=? WHERE id=?";
        jdbc.update(sql, null, null, user.getId());
        return user;
    }
}
