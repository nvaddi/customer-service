package com.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.exception.ResourceNotFoundException;
import com.customer.model.Customer;
import com.customer.repo.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;

	public Customer addCustomers(Customer customer) {
		System.out.println("Customer Id: " + customer.getCustId());
		System.out.println("Customer Name: " + customer.getCustName());
		System.out.print("Customer Address: " + customer.getCustAdd());
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(int custid) {
		return customerRepository.findById(custid).orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
	}
	
	public Customer updateCustomer(Customer customer) {
		Customer cust = customerRepository.findById(customer.getCustId()).orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
		cust.setCustName(customer.getCustName());
		cust.setCustAdd(customer.getCustAdd());
		return customerRepository.save(cust);
	}
	
	public String deleteCustomer(int custid) {
		Customer cust = customerRepository.findById(custid).orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
		customerRepository.delete(cust);
		return "Record deleted successfully";
	}
}
