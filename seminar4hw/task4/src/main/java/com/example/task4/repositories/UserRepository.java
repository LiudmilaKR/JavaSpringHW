package com.example.task4.repositories;

import com.example.task4.config.QueryConfiguration;
import com.example.task4.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс UserRepository работает с базой данных
 */
@Repository
@AllArgsConstructor
public class UserRepository {

    /**
     * Поле для работы с базой донных (объект подключения к БД)
     */
    private JdbcTemplate jdbc;

    /**
     * Поле конфигураций запросов к базе данных
     */
    private QueryConfiguration queryConfiguration;

    /**
     * Метод получения всех пользователей из базы данных
     * @return список всех пользователей
     */
    public List<User> getAllUsers() {
        String sql = queryConfiguration.getSelectAll();

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
        String sql = queryConfiguration.getInsertUser();
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    /**
     * Метод удаления пользователя из базы данных
     * @param id пользователя, которого необходимо удалить из базы данных
     */
    public void deleteUserById(int id) {
        String sql = queryConfiguration.getDeleteUser();
        jdbc.update(sql, id);
    }

    /**
     * Метод изменения пользователя в БД
     * @param user пользователь, которого меняем
     */
    public User updateUser(User user) {
        String sql = queryConfiguration.getUpdateUser();
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }

    /**
     * Метод поиска пользователя в базе данных по id
     * @param id пользователя, которого необходимо найти в базе данных
     * @return найденный пользователь
     */
    public User findUserById(int id) {
        String sql = queryConfiguration.getSelectById() + id;
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper).stream().findFirst().orElse(null);
    }
}
