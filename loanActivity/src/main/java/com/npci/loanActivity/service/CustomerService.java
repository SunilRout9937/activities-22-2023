package com.npci.loanActivity.service;

import com.npci.loanActivity.entities.Customer;

public interface CustomerService {
	
	public Customer registerUser(Customer customer);
	
	public Customer getCustomerOnEmail(String email);
}
