package com.peerlender.lendingengine.domain.service;

import com.peerlender.lendingengine.domain.exception.LoanApplicationNotFoundException;
import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.Loan;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlender.lendingengine.domain.repository.LoanRepository;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanService {
    private final LoanApplicationRepository loanApplicationRepository; //to find pending application
    private final UserRepository userRepository; //to find lender
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository,
                       LoanRepository loanRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    public void acceptLoan(final long loanApplicationID, final long lenderID) {
        User lender = userRepository.findById(lenderID).
                orElseThrow(() -> new UserNotFoundException(lenderID));//orElseThrow an Exception
        LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationID).
                orElseThrow(() -> new LoanApplicationNotFoundException(loanApplicationID));
        loanRepository.save(new Loan(lender,loanApplication));
    }

    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }
}
