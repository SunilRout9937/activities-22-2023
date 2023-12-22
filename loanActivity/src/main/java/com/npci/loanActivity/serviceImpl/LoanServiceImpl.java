package com.npci.loanActivity.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.loanActivity.entities.Loan;
import com.npci.loanActivity.repository.LoanRepository;
import com.npci.loanActivity.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;
	@Override
	public List<Loan> getAllLoans() {
		List<Loan> loans = new ArrayList<>();
        loans.add(createLoan("Housing Loan"));
        loans.add(createLoan("Educational Loan"));
        loans.add(createLoan("Gold Loan"));
        loans.add(createLoan("Personal Loan"));
        loans.add(createLoan("Car Loan"));
        loans.add(createLoan("Business Loan"));
        return loans;
	}

	private Loan createLoan(String type) {
		 Loan loan = new Loan();
	        loan.setType(type);
	        return loan;
	}

	@Override
	public Loan applyForLoan(String loanType) {
		// Implement logic to apply for a loan and update its status to Pending
        // For simplicity, we'll just update the status to Pending
		Loan loan=new Loan();
            loan.setStatus("Pending");
            loan.setType(loanType);
            return loanRepository.save(loan);
	}

	@Override
	public Loan getLoanStatus(Long loanId) {
		// Implement logic to retrieve the status of a loan
        // For simplicity, we'll just return the loan without modifying its status
        return loanRepository.findById(loanId).orElse(null);
	}

}
