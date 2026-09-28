package com.customer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	final CustomerService customerService;

	CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("/add")
	public Customer addCustomers(@RequestBody Customer customer) {
		return customerService.addCustomers(customer);
	}

	@GetMapping("/fetch")
	public List<Customer> getAllCustomers() {

		return customerService.getAllCustomers();

	}
	
	@GetMapping("/fetch/{custid}")
	public Customer getCustomerById(@PathVariable int custid) {
		return customerService.getCustomerById(custid);
	}
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/delete/{custId}")
	public String deleteCustomer(@PathVariable int custId) {
		return customerService.deleteCustomer(custId);
	}

}
