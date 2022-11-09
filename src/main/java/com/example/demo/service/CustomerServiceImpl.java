package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.example.demo.resource.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer find(long customerId) {
		String url = "http://localhost:8080/api/customer/"+customerId;
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		Customer customer = new Customer(100,"ozan",2000);
		Customer customer1 = new Customer(101,"özge",3000);
		Customer customer2 = new Customer(102,"arzu",4000);
		Customer customer3 = new Customer(103,"şerif",5000);
		Customer customer4 = new Customer(104,"tarçın",6000);
		
		List<Customer> customers = new ArrayList<Customer>();
		
		customers.add(customer);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		customers.add(customer1);
		
		return customers;
	}

	@Override
	public void insertCustomer(Customer customer) {
		
		customer.setCustomerId(101);
		System.out.println("customer eklendi "+customer.getCustomerId()+" "+customer.getCustomerName()+" "+customer.getTotalDebit() );
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("customer güncellendi "+customer.getCustomerId()+" "+customer.getCustomerName()+" "+customer.getTotalDebit());
		
	}

	@Override
	public void delete(long customerId) {
		Customer customer = new Customer(customerId,"tarçın",2000);
		System.out.println("customer silindi : "+customer.getCustomerName());
		
	}

}
