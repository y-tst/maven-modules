package edu.javamentoring.dto;

import java.time.LocalDate;

public class Subscription {

    private String bankcard;
    private LocalDate startDate;

    public Subscription(String bankcard, LocalDate startDate) {
        this.bankcard = bankcard;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "edu.javamentoring.dto.Subscription{" +
                "bankcard='" + bankcard + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
