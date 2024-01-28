package com.example.seminar3hw.domain;

/**
 * Класс User - пользователь
 */
public class User {
    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Возраст пользователя
     */
    private int age;
    /**
     * email пользователя
     */
    private String email;

    // region геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // endregion
}
