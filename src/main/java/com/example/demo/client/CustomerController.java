package com.example.demo.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.resource.Customer;


@Controller
public class CustomerController {
	
	@GetMapping("/customer/get")
	@ResponseBody
	public String getCustomer() {
		long customerId = 100;
		String url = "http://localhost:8080/api/customer/"+customerId;
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		return "Edinme başarılı :"+customer.getCustomerId()+" "+customer.getCustomerName()+" "+customer.getTotalDebit();
	}
	
	@GetMapping("/customer/post")
	@ResponseBody
	public String postCustomer() {
		
		Customer customer = new Customer(100,"ozan",1000);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		Customer result = restTemplate.postForObject(url, customer, Customer.class);
		
		return "Yollama başarılı "+result.getCustomerId()+" "+result.getCustomerName()+" "+result.getTotalDebit();
	
	}
	
	@GetMapping("/customer/put")
	@ResponseBody
	public String putCustomer() {
		Customer customer = new Customer(101,"özge",3000);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT,new HttpEntity<Customer>(customer),Void.class);
		return "Güncellendi";
		
	}
	
	@GetMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomert() {
		Customer customer = new Customer(103,"arzu",3000);
		String url = "http://localhost:8080/api/product/"+customer.getCustomerId();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.DELETE,new HttpEntity<Customer>(customer),Void.class);
		return "Silindi";
		
	}

}
