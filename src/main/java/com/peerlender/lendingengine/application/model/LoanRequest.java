package com.peerlender.lendingengine.application.model;

import com.peerlender.lendingengine.domain.model.User;


import java.util.Objects;

public class LoanRequest {
    private final int amount;
    private final long borrowerID;
    private final int daysToRepay;
    private final double interestRate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanRequest that = (LoanRequest) o;
        return amount == that.amount && borrowerID == that.borrowerID && daysToRepay == that.daysToRepay &&
                Double.compare(that.interestRate, interestRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrowerID, daysToRepay, interestRate);
    }

    public int getAmount() {
        return amount;
    }

    public long getBorrowerID() {
        return borrowerID;
    }

    public int getDaysToRepay() {
        return daysToRepay;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public LoanRequest(int amount, long borrowerID, int daysToRepay, double interestRate) {
        this.amount = amount;
        this.borrowerID = borrowerID;
        this.daysToRepay = daysToRepay;
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrowerID=" + borrowerID +
                ", daysToRepay=" + daysToRepay +
                ", interestRate=" + interestRate +
                '}';
    }
}
