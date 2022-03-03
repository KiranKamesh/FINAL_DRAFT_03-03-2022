package com.mouritech.onlinebookstoremanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mouritech.onlinebookstoremanagement.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>
{

//	boolean existsByCId(Long cid);
//
	boolean existsCustomerByCustomerId(Long customerId);

	Optional<Customer> findByCustomerId(Long customerId);





}
