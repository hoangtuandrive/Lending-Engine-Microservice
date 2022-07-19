package com.peerlender.lendingengine.domain.repository;

import com.peerlender.lendingengine.domain.model.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

//registered as Bean because extended JpaRepo
public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long> {

}
