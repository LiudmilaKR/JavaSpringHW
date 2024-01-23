package com.example.seminar2HW.model;

import java.util.Objects;

/**
 * Класс User пользователь
 */
public class User {
    /**
     * идентификационный номер пользователя
     */
    private int id;
    /**
     * имя пользователя
     */
    private String firstName;
    /**
     * фамилия пользователя
     */
    private String lastName;

    // region геттеры-сеттеры для полей класса
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // endregion

    /**
     * Метод определения равенства объекта класса с заданным объектом o
     * @param o - сравниваемый объект
     * @return - True, если объекты одинаковы и False - в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (!(o instanceof User user)) return false;
        if (o == null || getClass() != o.getClass()) return false;
//        return Objects.equals(getId(), user.getId()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName());
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.getFirstName()) && Objects.equals(lastName, user.getLastName());
    }

    /**
     * Метод формирования хешкода объекта
     * @return хэшкод объекта
     */
    @Override
    public int hashCode() {
//        return Objects.hash(getId(), getFirstName(), getLastName());
        return Objects.hash(id, firstName, lastName);
    }
}
