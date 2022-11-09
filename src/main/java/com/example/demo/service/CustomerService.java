package com.example.demo.service;

import java.util.List;

import com.example.demo.resource.Customer;

public interface CustomerService {
	Customer find(long customerId);
	
	List<Customer> findAll();
	
	void insertCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void delete(long customerId);
}
