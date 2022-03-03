package com.mouritech.onlinebookstoremanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinebookstoremanagement.dto.response.BookSalesRecordDto;
import com.mouritech.onlinebookstoremanagement.entity.Customer;
import com.mouritech.onlinebookstoremanagement.entity.SalesRecord;

@Repository
public interface SalesRecordRepository extends JpaRepository<SalesRecord, Long> 
{
	
	
	List<SalesRecord> findByCustomer_CustomerId(Long customerId);

	Optional<SalesRecord> findBySalesId(String salesId);

	List<SalesRecord> findSalesRecordByBookISBN(Long bookISBN);
	
}
