package com.example.demo.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;

@RestController
public class CustomerResource {

	//@Autowired
	private CustomerService customerService;
	
	public CustomerResource(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@GetMapping("/api/customer/{id}")
	public Customer getCustomer(@PathVariable("id")long customerId) {
		Customer customer = customerService.find(customerId);
		return customer;		
	}
	
	@GetMapping("/api/customers")
	public List<Customer> getCustomers(){
		
		List<Customer> customers = customerService.findAll();
		return customers;
		
	}
	
	@PostMapping("/api/customer")
	public void postCustomer(@RequestBody Customer customer) {
		customerService.insertCustomer(customer);
	}
	
	@PutMapping("/api/customer")
	public void putCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}
	
	
	@DeleteMapping("/api/customer/{id}")
	public void deleteCustomer(@PathVariable("id")long customerId) {
		customerService.delete(customerId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
