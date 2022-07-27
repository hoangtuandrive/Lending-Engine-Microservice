package com.peerlender.lendingengine.domain.repository;

import com.peerlender.lendingengine.domain.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

//registered as Bean because extended JpaRepo
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

}
