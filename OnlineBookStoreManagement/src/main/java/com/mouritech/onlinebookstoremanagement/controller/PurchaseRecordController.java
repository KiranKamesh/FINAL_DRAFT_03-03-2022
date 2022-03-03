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

import com.mouritech.onlinebookstoremanagement.dto.response.BookPurchaseRecordDto;
import com.mouritech.onlinebookstoremanagement.dto.response.BookSalesRecordDto;
import com.mouritech.onlinebookstoremanagement.entity.PurchaseRecord;
import com.mouritech.onlinebookstoremanagement.entity.SalesRecord;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.PurchaseRecordNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.SalesRecordNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.SupplierNotFoundException;
import com.mouritech.onlinebookstoremanagement.service.PurchaseRecordService;

@RestController
@RequestMapping("purchaserecord/api/v1")
public class PurchaseRecordController {

	@Autowired
	PurchaseRecordService purchaseRecordService;

	@PostMapping("/purchaserecord")
	public PurchaseRecord savePurchaseRecord(@RequestBody PurchaseRecord newPurchaseRecord) {
		return purchaseRecordService.insertPurchaseRecord(newPurchaseRecord);
	}

	@GetMapping("/purchaserecord")
	public List<PurchaseRecord> getAllPurchaseRecords() {
		return purchaseRecordService.showAllPurchaseRecords();

	}

	@GetMapping("purchaserecord/{pid}")
	public PurchaseRecord showPurchaseRecordById(@PathVariable("pid") String purchaseId)
			throws PurchaseRecordNotFoundException {
		return purchaseRecordService.showPurchaseRecordById(purchaseId);
	}

	// update a purchaseRecord
	@PutMapping("purchaseRecord/{pid}")
	public PurchaseRecord updatePurchaseRecordById(@PathVariable("pid") String purchaseId,
			@RequestBody PurchaseRecord purchaseRecord) throws PurchaseRecordNotFoundException {
		return purchaseRecordService.updatePurchaseRecordById(purchaseId, purchaseRecord);
	}

	@DeleteMapping("purchaseRecord/{pid}")
	public String deletePurchaseRecordById(@PathVariable("pid") String purchaseId)
			throws PurchaseRecordNotFoundException {
		purchaseRecordService.deletePurchaseRecordById(purchaseId);
		return "purchaseRecord deleted";

	}
	
	@PostMapping("purchaserecord/{sid}/supplier")
	public ResponseEntity<PurchaseRecord> createPurchaseRecord(@PathVariable("sid") Long supplierId,
			@RequestBody PurchaseRecord purchaseRecord) throws SupplierNotFoundException {
		return purchaseRecordService.createPurchaseRecord(supplierId,purchaseRecord);
		
	}
	
	@GetMapping("/purchaserecordbyid/{sid}")
	public ResponseEntity<List<PurchaseRecord>> getAllPurchaseRecordsBySupplierId(@PathVariable("sid") Long supplierId) throws SupplierNotFoundException {
		return purchaseRecordService.getAllSalesRecordsByCustomerId(supplierId);
	}
	
	@PutMapping("purchaserecordbyid/{pid}/supplier")
	public PurchaseRecord updatePurchaseById(@PathVariable("pid") String purchaseId, @RequestBody PurchaseRecord purchaseRecord)
			throws PurchaseRecordNotFoundException {
		return purchaseRecordService.updatePurchaseById(purchaseId, purchaseRecord);
	}
	
	@GetMapping("purchaserecord/bookisbn/{bookISBN}")
	public BookPurchaseRecordDto getPurchaseRecordByBookISBN(@PathVariable("bookISBN") Long bookISBN) throws PurchaseRecordNotFoundException{
		return purchaseRecordService.getPurchaseRecordByBookISBN(bookISBN);
	}

}
