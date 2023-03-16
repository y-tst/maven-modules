package edu.javamentoring.bank.api;

import edu.javamentoring.dto.BankCard;
import edu.javamentoring.dto.BankCardType;
import edu.javamentoring.dto.User;

public interface Bank {

    BankCard createBankCard(User user, BankCardType bankCardType);
}
