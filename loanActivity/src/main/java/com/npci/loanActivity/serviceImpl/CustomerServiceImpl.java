package com.npci.loanActivity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.loanActivity.entities.Customer;
import com.npci.loanActivity.repository.CustomerRepository;
import com.npci.loanActivity.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer registerUser(Customer customer) {
	 Customer savedCustomer= repo.save(customer);
	 return savedCustomer;
	}

	@Override
	public Customer getCustomerOnEmail(String email) {
		Customer customer=repo.getCustomerOnEmail(email);
		return customer;
	}

}
