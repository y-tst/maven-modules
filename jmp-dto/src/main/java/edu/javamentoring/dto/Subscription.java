package edu.javamentoring.dto;

import java.time.LocalDate;

public class Subscription {

    private String bankcard;
    private LocalDate startDate;

    public Subscription(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

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
