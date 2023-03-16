package edu.javamentoring.application;

import edu.javamentoring.cloud.service.impl.CreateUserImpl;
import edu.javamentoring.dto.BankCardType;
import edu.javamentoring.dto.User;
import edu.javamentoring.cloud.bank.impl.BankImpl;

import java.util.Scanner;


public class Demo {

    public static void main(String[] args) {

        CreateUserImpl createUser = new CreateUserImpl();
        User brandNewUser = createUser.newUser();

        var scanner = new Scanner(System.in);

        System.out.println("Which Card type do you prefer? Credit - input 'c', Debit - input 'd': ");
        var cardType = scanner.nextLine();

        BankCardType bankCardType = null;
        if (cardType.equals("c")) {
            bankCardType = BankCardType.CREDIT;
        } else if (cardType.equals("d")) {
            bankCardType = BankCardType.DEBIT;
        } else
            throw new IllegalArgumentException("Incorrect Card type");

        var bankImpl = new BankImpl();

        var createdBankCard = bankImpl.createBankCard(brandNewUser, bankCardType);

        System.out.println("Brand new card for " + createdBankCard.getUser() + " was issued.");
        System.out.println("The Card number is  " + createdBankCard.getNumber());
    }
}
