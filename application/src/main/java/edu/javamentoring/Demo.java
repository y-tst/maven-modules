package edu.javamentoring;

import edu.javamentoring.dto.BankCard;
import edu.javamentoring.dto.BankCardType;
import edu.javamentoring.dto.User;
import edu.javamentoring.cloud.bank.impl.BankImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Name: ");
        String name = scanner.nextLine();
        System.out.println("Input Surname: ");
        String surname = scanner.nextLine();
        System.out.println("Input Date of Birth in format YYYY.MM.DD: ");
        String stringBirthDate = scanner.nextLine();
        LocalDate birthday = LocalDate.of(Integer.parseInt(stringBirthDate.substring(0, 4))
                , Integer.parseInt(stringBirthDate.substring(5, 7))
                , Integer.parseInt(stringBirthDate.substring(9)));
        System.out.println("Which Card type do you prefer? Credit - input 'c', Debit - input 'd': ");
        String cardType = scanner.nextLine();
        BankCardType bankCardType = null;
        if (cardType.equals("c")) {
            bankCardType = BankCardType.CREDIT;
        } else if (cardType.equals("d")) {
            bankCardType = BankCardType.DEBIT;
        } else
            throw new IllegalArgumentException("Incorrect Card type");

        User createdUser = new User(name, surname, birthday);

        BankImpl bankImpl = new BankImpl();

        BankCard createdBankCard = bankImpl.createBankCard(createdUser, bankCardType);

        System.out.println("Brand new card for " + createdBankCard.getUser() + " was issued.");
        System.out.println("The Card number is  " + createdBankCard.getNumber());
    }
}
