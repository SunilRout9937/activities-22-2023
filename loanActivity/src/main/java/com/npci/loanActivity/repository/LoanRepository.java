package com.npci.loanActivity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.loanActivity.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
