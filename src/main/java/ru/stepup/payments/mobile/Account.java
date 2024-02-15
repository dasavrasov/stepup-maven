package ru.stepup.payments.mobile;

public abstract class Account {
    String num;
    Double balance;
    private Double comiss;
    private Currency currency;

    Account(String num, Double balance, Double comiss, Currency currency) {
        this.num = num;
        this.balance = balance;
        this.comiss = comiss;
        this.currency = currency;
    }

    Account(String num, Double balance, Double comiss) {
        this(num, balance, comiss, Currency.RUB);
    }

    Double getComiss() {
        return comiss;
    }

    Currency getCurrency() {
        return currency;
    }

    void setComiss(Double comiss) {
        this.comiss = comiss;
    }

    void setCurrency(Currency currency) {
        this.currency = currency;
    }
    void balanceMinusComis() {
        balance = balance - comiss;
    }
    Double Debit(Double amount) {
        balance -= amount;
        return balance;
    }
    Double Credit(Double amount) {
        balance += amount;
        return balance;
    }

    String getNum() {
        return num;
    }

    Double getBalance() {
        return balance;
    }

    void creaditAccount(Double amount){
        balance += amount;
    }
}
