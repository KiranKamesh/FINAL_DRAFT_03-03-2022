package com.mouritech.onlinebookstoremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinebookstoremanagement.entity.Customer;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;
import com.mouritech.onlinebookstoremanagement.repository.CustomerRepository;
import com.mouritech.onlinebookstoremanagement.service.CustomerService;
import com.mouritech.onlinebookstoremanagement.service.SalesRecordService;

@RestController
@RequestMapping("customer/api/v1")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer newCustomer) {
		return customerService.insertCustomer(newCustomer);
	}

	@GetMapping("/customer")
	public List<Customer> getAllCustomers() {
		return customerService.showAllCustomers();

	}

	// get a customer by id
	@GetMapping("customer/{cid}")
	public Customer showCustomerById(@PathVariable("cid") Long customerId) throws CustomerNotFoundException {
		return customerService.showCustomerById(customerId);
	}

	// update a customer
	@PutMapping("customer/{cid}")
	public Customer updateCustomerById(@PathVariable("cid") Long customerId, @RequestBody Customer customer)
			throws CustomerNotFoundException {
		return customerService.updateCustomerById(customerId, customer);

	}

	@DeleteMapping("customer/{cid}")
	public String deleteCustomerById(@PathVariable("cid") Long customerId) throws CustomerNotFoundException {
		customerService.deleteCustomerById(customerId);
		return "customer deleted";

	}

}