package com.peerlender.lendingengine.domain.exception;

public class LoanApplicationNotFoundException extends RuntimeException {
    public LoanApplicationNotFoundException(long loanApplicationID)  {
        super("Loan Application with id: " + loanApplicationID + " not found!");
    }
}
