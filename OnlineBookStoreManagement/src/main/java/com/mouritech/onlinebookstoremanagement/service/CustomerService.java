package com.mouritech.onlinebookstoremanagement.service;

import java.util.*;


import com.mouritech.onlinebookstoremanagement.entity.Customer;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;

public interface CustomerService {
	Customer insertCustomer(Customer newCustomer);

	Customer showCustomerById(Long customerId) throws CustomerNotFoundException;

	List<Customer> showAllCustomers();

	Customer updateCustomerById(Long customerId, Customer customer) throws CustomerNotFoundException;

	void deleteCustomerById(Long customerId) throws CustomerNotFoundException;

//	ResponseEntity<List<Customer>> getAllCustomersBySalesId(int SalesId) throws SalesRecordNotFoundException;
//
//	ResponseEntity<Customer> createCustomer(int SalesId, Customer newCustomer) throws SalesRecordNotFoundException;
//
//	Customer getCustomerNameBySalesId(int SalesId, String customername) throws CustomerNameAlreadyExistsException;
//
//	
}
