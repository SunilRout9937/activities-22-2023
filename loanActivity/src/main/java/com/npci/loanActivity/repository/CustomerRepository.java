package com.npci.loanActivity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.loanActivity.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM customer c WHERE c.email = ?1")
	public Customer getCustomerOnEmail(String email);
}
