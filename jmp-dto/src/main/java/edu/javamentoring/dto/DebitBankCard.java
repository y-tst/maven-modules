package edu.javamentoring.dto;

public class DebitBankCard extends BankCard {

    BankCardType debitCard = BankCardType.DEBIT;

    public DebitBankCard(String number, User user) {
        super(number, user);
    }
}
