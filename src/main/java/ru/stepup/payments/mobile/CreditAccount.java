package ru.stepup.payments.mobile;

import java.time.Year;

public class CreditAccount extends Account {
    private Double rate;
    private Double limit;
    private Double percentAmount;
    private Double comissAmount;

    public CreditAccount(String num, Double balance, Double comiss, Currency currency) {
        super(num, balance, comiss, currency);
    }

    public CreditAccount(String num, Double balance, Double comiss) {
        super(num, balance, comiss);
    }

    public Double getRate() {
        return rate;
    }

    public Double getLimit() {
        return limit;
    }

    public Double getPercentAmount() {
        return percentAmount;
    }

    public Double getComissAmount() {
        return comissAmount;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public void setPercentAmount(Double percentAmount) {
        this.percentAmount = percentAmount;
    }

    public void setComissAmount(Double comissAmount) {
        this.comissAmount = comissAmount;
    }
    private int daysInCurrentYear(){
        if (Year.now().getValue() % 4 == 0){
            return 366;
        }
        return 365;
    }


    public void interestCalculation(){
        this.percentAmount = this.balance < this.limit ? this.percentAmount + (this.limit - this.balance)* this.rate / daysInCurrentYear() /100 : this.percentAmount;
    }

    @Override
    public void balanceMinusComis() {
        this.comissAmount+=this.getComiss();
    }

    @Override
    void creaditAccount(Double amount) {
        Double rest = Math.max(amount-this.comissAmount,0.0);
        this.comissAmount = Math.max(this.comissAmount - amount,0.0);
        if (rest>0){
            rest=Math.max(rest-this.percentAmount,0.0);
            this.percentAmount = Math.max(this.percentAmount - rest,0.0);
        }
        if (rest>0){
            this.balance+=rest;
        }
    }
}
