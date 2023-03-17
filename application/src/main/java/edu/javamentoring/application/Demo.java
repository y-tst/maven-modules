package edu.javamentoring.application;

import edu.javamentoring.cloud.service.impl.CreateUserImpl;
import edu.javamentoring.cloud.service.impl.ServiceImpl;
import edu.javamentoring.dto.BankCardType;
import edu.javamentoring.dto.User;
import edu.javamentoring.cloud.bank.impl.BankImpl;
import edu.javamentoring.service.api.Service;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        var bankImpl = new BankImpl();
        var service = new ServiceImpl();
        var createUser = new CreateUserImpl();
        var scanner = new Scanner(System.in);

        System.out.println("Creating a User:");

        User brandNewUser = createUser.newUser();

        System.out.println("Which Card type do you prefer? Credit - input 'c', Debit - input 'd': ");
        var cardType = scanner.nextLine();

        BankCardType bankCardType = null;
        if (cardType.equals("c")) {
            bankCardType = BankCardType.CREDIT;
        } else if (cardType.equals("d")) {
            bankCardType = BankCardType.DEBIT;
        } else throw new IllegalArgumentException("Incorrect Card type");

        var createdBankCard = bankImpl.createBankCard(brandNewUser, bankCardType);

        System.out.println("Brand new card for " + createdBankCard.getUser() + " was issued.");
        System.out.println("The Card number is  " + createdBankCard.getNumber());

        System.out.println("Is user adult (more than 18 years old)? - " + Service.isPayableUser(brandNewUser));

        service.subscribe(createdBankCard);

        System.out.println("The subscription was done");

        System.out.println("Performing the check: ");

        service.getAllUsers().forEach(System.out::println);
        service.getSubscriptionByBankCardNumber(createdBankCard.getNumber()).ifPresentOrElse(System.out::println, () -> System.out.println("User has no subscriptions."));

        System.out.println("The average age of all users: " + service.getAverageUsersAge());

        System.out.println("Using Collectors.toUnmodifiableList() for Users performing: ");
        service.getAllUsersInUppercase(service.getAllUsers()).forEach(System.out::println);
    }
}