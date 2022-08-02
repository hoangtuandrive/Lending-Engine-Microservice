package com.peerlender.lendingengine.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Loan {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    private int amount;
    private double interestRate;
    private LocalDate dateLent;
    private LocalDate dateDue;

    public Loan() {
    }

    //transform loan application to loan object with a lender
    public Loan(User lender, LoanApplication loanApplication) {
        this.borrower = loanApplication.getBorrower();
        this.lender = lender;
        this.amount = loanApplication.getAmount();
        this.interestRate = loanApplication.getInterestRate();
        this.dateLent = LocalDate.now(); //get current date
        this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTermInDays()); //current date + day to repay
    }

    public long getId() {
        return id;
    }

    public User getBorrower() {
        return borrower;
    }

    public User getLender() {
        return lender;
    }

    public int getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public LocalDate getDateLent() {
        return dateLent;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }
}
