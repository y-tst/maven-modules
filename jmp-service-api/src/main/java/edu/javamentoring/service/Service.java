package edu.javamentoring.service;

import edu.javamentoring.dto.BankCard;
import edu.javamentoring.dto.Subscription;
import edu.javamentoring.dto.User;

import java.util.List;
import java.util.Optional;

public interface Service {

    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String s);
    List<User> getAllUsers();
}
