package com.npci.loanActivity.service;

import java.util.List;

import com.npci.loanActivity.entities.Loan;

public interface LoanService {

	public List<Loan> getAllLoans();
	public Loan applyForLoan(String loanType);
	public Loan getLoanStatus(Long loanId);
}
