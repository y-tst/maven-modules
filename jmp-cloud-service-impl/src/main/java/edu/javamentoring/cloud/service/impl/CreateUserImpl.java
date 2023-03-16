package edu.javamentoring.cloud.service.impl;

import edu.javamentoring.dto.User;
import edu.javamentoring.service.api.CreateUser;

import java.time.LocalDate;
import java.util.Scanner;

public class CreateUserImpl implements CreateUser {

    @Override
    public User newUser() {

        var scanner = new Scanner(System.in);

        System.out.println("Input Name: ");
        var name = scanner.nextLine();

        System.out.println("Input Surname: ");
        var surname = scanner.nextLine();

        System.out.println("Input Date of Birth in format YYYY-MM-DD: ");
        var stringBirthDate = scanner.nextLine();

        LocalDate birthday = LocalDate.parse(stringBirthDate);

        return new User(name, surname, birthday);
    }
}
