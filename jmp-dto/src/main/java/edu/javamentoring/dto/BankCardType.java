package edu.javamentoring.dto;

public enum BankCardType {

    CREDIT("4444"),
    DEBIT("5555");

    public String firstFourDigits;

    BankCardType(String firstFourDigits) {
        this.firstFourDigits = firstFourDigits;
    }

    public String getfirstFourDigits() {
        return firstFourDigits;
    }

    @Override
    public String toString() {
        return "Card type '" + this.name() + "' stands for " + firstFourDigits;
    }
}
