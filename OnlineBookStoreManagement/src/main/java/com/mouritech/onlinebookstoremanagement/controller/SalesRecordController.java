package com.mouritech.onlinebookstoremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinebookstoremanagement.dto.response.BookSalesRecordDto;
import com.mouritech.onlinebookstoremanagement.entity.SalesRecord;
import com.mouritech.onlinebookstoremanagement.exception.BookNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.SalesRecordNotFoundException;
import com.mouritech.onlinebookstoremanagement.service.CustomerService;
import com.mouritech.onlinebookstoremanagement.service.SalesRecordService;

@RestController
@RequestMapping("salesrecord/api/v1")
public class SalesRecordController {

	@Autowired
	SalesRecordService salesRecordService;

	@PostMapping("/salesrecord")
	public SalesRecord saveSalesRecord(@RequestBody SalesRecord newSalesRecord) {
		return salesRecordService.insertSalesRecord(newSalesRecord);
	}

	@GetMapping("/salesrecord")
	public ResponseEntity<List<SalesRecord>> getAllSalesRecords() {
		List<SalesRecord> salesrecordList = salesRecordService.showAllSalesRecords();
		return ResponseEntity.ok().body(salesrecordList);

	}

	@GetMapping("salesrecord/{salid}")
	public SalesRecord showSalesRecordById(@PathVariable("salid") String salesId) throws SalesRecordNotFoundException {
		return salesRecordService.showSalesRecordById(salesId);
	}

	// update a salesRecord
	@PutMapping("salesRecord/{salid}")
	public SalesRecord updateSalesRecordById(@PathVariable("salid") String salesId,
			@RequestBody SalesRecord salesRecord) throws SalesRecordNotFoundException {
		return salesRecordService.updateSalesRecordById(salesId, salesRecord);
	}

	@DeleteMapping("salesRecord/{salid}")
	public String deleteSalesRecordById(@PathVariable("salid") String salesId) throws SalesRecordNotFoundException {
		salesRecordService.deleteSalesRecordById(salesId);
		return "salesRecord deleted";

	}

	@PostMapping("salesrecord/{cid}/customer")
	public ResponseEntity<SalesRecord> createSalesRecord(@PathVariable("cid") Long customerId,
			@RequestBody SalesRecord salesRecord) throws CustomerNotFoundException {
		return salesRecordService.createSalesRecord(customerId, salesRecord);

	}

	@GetMapping("/salesrecordbyid/{cid}")
	public ResponseEntity<List<SalesRecord>> getAllSalesRecordsByCustomerId(@PathVariable("cid") Long customerId)
			throws CustomerNotFoundException {
		return salesRecordService.getAllSalesRecordsByCustomerId(customerId);
	}



	@PutMapping("salesrecordbyid/{salid}/customer")
	public SalesRecord updateSalesById(@PathVariable("salid") String salesId, @RequestBody SalesRecord salesRecord)
			throws SalesRecordNotFoundException {
		return salesRecordService.updateSalesById(salesId, salesRecord);
	}
	
	@GetMapping("salesrecord/bookisbn/{bookISBN}")
	public BookSalesRecordDto getSalesRecordByBookISBN(@PathVariable("bookISBN") Long bookISBN) throws SalesRecordNotFoundException{
		return salesRecordService.getSalesRecordByBookISBN(bookISBN);
	}

}
