package edu.javamentoring.service.api;

import edu.javamentoring.dto.BankCard;
import edu.javamentoring.dto.Subscription;
import edu.javamentoring.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public interface Service {

    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);
    List<User> getAllUsers();

    List<User> getAllUsersInUppercase(List<User> users);

    default double getAverageUsersAge() {
        return getAllUsers().stream()
                .mapToLong(user -> {return  ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now());})
                .average()
                .orElse(Double.NaN);
    }

    static boolean isPayableUser(User user) {
        return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()) > 18;
    }
}
