package ru.stepup.payments.mobile;

public class DebitAccount extends Account {
    public DebitAccount(String num, Double balance, Double comiss, Currency currency) {
        super(num, balance, comiss, currency);
    }

    public DebitAccount(String num, Double balance, Double comiss) {
        super(num, balance, comiss);
    }
}
