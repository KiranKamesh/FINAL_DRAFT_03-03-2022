package com.mouritech.onlinebookstoremanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinebookstoremanagement.dto.response.BookPurchaseRecordDto;
import com.mouritech.onlinebookstoremanagement.entity.PurchaseRecord;
import com.mouritech.onlinebookstoremanagement.exception.PurchaseRecordNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.SupplierNotFoundException;

public interface PurchaseRecordService {

	PurchaseRecord insertPurchaseRecord(PurchaseRecord newPurchaseRecord);

	List<PurchaseRecord> showAllPurchaseRecords();

	PurchaseRecord showPurchaseRecordById(String purchaseId) throws PurchaseRecordNotFoundException;

	PurchaseRecord updatePurchaseRecordById(String purchaseId, PurchaseRecord purchaseRecord) throws PurchaseRecordNotFoundException;

	void deletePurchaseRecordById(String purchaseId) throws PurchaseRecordNotFoundException;

	ResponseEntity<PurchaseRecord> createPurchaseRecord(Long supplierId, PurchaseRecord purchaseRecord) throws SupplierNotFoundException;

	ResponseEntity<List<PurchaseRecord>> getAllSalesRecordsByCustomerId(Long supplierId) throws SupplierNotFoundException;

	PurchaseRecord updatePurchaseById(String purchaseId, PurchaseRecord purchaseRecord) throws PurchaseRecordNotFoundException;

	BookPurchaseRecordDto getPurchaseRecordByBookISBN(Long bookISBN) throws PurchaseRecordNotFoundException;

	

}
