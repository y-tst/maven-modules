package edu.javamentoring.cloud.service.impl;

import edu.javamentoring.dto.BankCard;
import edu.javamentoring.dto.Subscription;
import edu.javamentoring.dto.User;
import edu.javamentoring.service.api.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {

    private final Map<User, List<BankCard>> userStorage = new HashMap<>();
    private final List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {

        var user = bankCard.getUser();

        userStorage.computeIfAbsent(user, u -> new ArrayList<>()).add(bankCard);

        subscriptions.add(new Subscription(bankCard.getNumber(), LocalDate.now()));
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return subscriptions.stream().filter(subscription -> subscription.getBankcard().equals(cardNumber)).findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userStorage.keySet());
    }

    @Override
    public List<User> getAllUsersInUppercase(List<User> users) {
        return users.stream()
                .map(user -> new User(user.getName().toUpperCase()
                        , user.getSurname().toUpperCase()
                        , user.getBirthday()))
                .collect(Collectors.toUnmodifiableList());
    }
}
