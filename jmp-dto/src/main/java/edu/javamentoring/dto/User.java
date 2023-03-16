package edu.javamentoring.dto;

import java.time.LocalDate;

public class User {

    private String name;
    private String surname;
    private LocalDate birthday;

    public User(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "edu.javamentoring.dto.User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
