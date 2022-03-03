package com.mouritech.onlinebookstoremanagement.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.mouritech.onlinebookstoremanagement.dto.response.BookSalesRecordDto;
import com.mouritech.onlinebookstoremanagement.entity.SalesRecord;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.SalesRecordNotFoundException;
public interface SalesRecordService {

	
	SalesRecord insertSalesRecord(SalesRecord newSalesRecord);

	SalesRecord showSalesRecordById(String SalesId) throws SalesRecordNotFoundException;

	List<SalesRecord> showAllSalesRecords();

	SalesRecord updateSalesRecordById(String SalesId, SalesRecord salesRecord) throws SalesRecordNotFoundException;

	void deleteSalesRecordById(String SalesId) throws  SalesRecordNotFoundException;

	ResponseEntity<List<SalesRecord>> getAllSalesRecordsByCustomerId(Long customerId) throws CustomerNotFoundException;


	ResponseEntity<SalesRecord> createSalesRecord(Long customerId, SalesRecord salesRecord) throws CustomerNotFoundException;

	SalesRecord updateSalesById(String salesId, SalesRecord salesRecord) throws SalesRecordNotFoundException;

	BookSalesRecordDto getSalesRecordByBookISBN(Long bookISBN) throws SalesRecordNotFoundException;


	

}
