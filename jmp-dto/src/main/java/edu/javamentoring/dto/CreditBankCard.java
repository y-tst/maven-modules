package edu.javamentoring.dto;

public class CreditBankCard extends BankCard {

    BankCardType creditCard = BankCardType.CREDIT;

    public CreditBankCard(String number, User user) {
        super(number, user);
    }
}
