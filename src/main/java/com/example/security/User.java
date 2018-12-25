package com.example.security;

/**
 * Класс объекта "Пользователь" для хранения информации о кол-ве входов в систему
 */
public class User {

    private int countEntries;

    public User(int countEnttries) {
        this.countEntries = countEntries;
    }

    User() {
    }

    public int getCountEntries() {
        return countEntries;
    }

    public void setCountEntries(int countEntries) {
        this.countEntries = countEntries;
    }

    @Override
    public String toString() {
        return " Пользователь { " +
                " Кол-во входов в систему = " + countEntries +
                '}';
    }

}
