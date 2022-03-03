package com.mouritech.onlinebookstoremanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlinebookstoremanagement.dto.response.BookPurchaseRecordDto;
import com.mouritech.onlinebookstoremanagement.dto.response.BookSalesRecordDto;
import com.mouritech.onlinebookstoremanagement.dto.response.PurchaseRecordDto;
import com.mouritech.onlinebookstoremanagement.dto.response.SalesRecordDto;
import com.mouritech.onlinebookstoremanagement.entity.Book;
import com.mouritech.onlinebookstoremanagement.entity.PurchaseRecord;
import com.mouritech.onlinebookstoremanagement.entity.SalesRecord;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.PurchaseRecordNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.SupplierNotFoundException;
import com.mouritech.onlinebookstoremanagement.repository.BookRepository;
import com.mouritech.onlinebookstoremanagement.repository.PurchaseRecordRepository;
import com.mouritech.onlinebookstoremanagement.repository.SupplierRepository;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

	@Autowired
	PurchaseRecordRepository purchaseRecordRepository;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	BookRepository bookRepository;

	public void deletePurchaseRecordById(String purchaseId) throws PurchaseRecordNotFoundException {
		PurchaseRecord exisitingPurchaseRecord = purchaseRecordRepository.findByPurchaseId(purchaseId).orElseThrow(
				() -> new PurchaseRecordNotFoundException("The following record is not found with the ID"));
		purchaseRecordRepository.delete(exisitingPurchaseRecord);

	}

	public PurchaseRecord updatePurchaseRecordById(String purchaseId, PurchaseRecord purchaseRecord)
			throws PurchaseRecordNotFoundException {
		PurchaseRecord exisitingPurchaseRecord = purchaseRecordRepository.findByPurchaseId(purchaseId).orElseThrow(
				() -> new PurchaseRecordNotFoundException("The following record with the id is not found"));

		exisitingPurchaseRecord.setPurchaseNoteNo(purchaseRecord.getPurchaseNoteNo());
		exisitingPurchaseRecord.setAmountPaid(purchaseRecord.getAmountPaid());
		exisitingPurchaseRecord.setAmountToPay(exisitingPurchaseRecord.getAmountPaid());
		exisitingPurchaseRecord.setBalance(exisitingPurchaseRecord.getBalance());
		exisitingPurchaseRecord.setNoOfCopies(exisitingPurchaseRecord.getNoOfCopies());
		return purchaseRecordRepository.save(exisitingPurchaseRecord);
	}

	public PurchaseRecord showPurchaseRecordById(String purchaseId) throws PurchaseRecordNotFoundException {
		return purchaseRecordRepository.findByPurchaseId(purchaseId).orElseThrow(
				() -> new PurchaseRecordNotFoundException("The following record is not found with the ID"));

	}

	public List<PurchaseRecord> showAllPurchaseRecords() {
		return purchaseRecordRepository.findAll();
	}

	public PurchaseRecord insertPurchaseRecord(PurchaseRecord newPurchaseRecord) {
		newPurchaseRecord.setPurchaseId(generatePurchaseId());
		return purchaseRecordRepository.save(newPurchaseRecord);

	}
	
	public String generatePurchaseId() {
		Random rand = new Random(); // instance of random class
		int upperbound = 255;
		// generate random values from 0-254
		Long pId = (long) rand.nextInt(upperbound);
		return "PUR00" + pId;

	}

	@Override
	public ResponseEntity<PurchaseRecord> createPurchaseRecord(Long supplierId, PurchaseRecord purchaseRecord) throws SupplierNotFoundException {
		PurchaseRecord purchaseRecord1 = supplierRepository.findBySupplierId(supplierId).map(
				supplier ->{
					purchaseRecord.setSupplier(supplier);
					purchaseRecord.setPurchaseId(generatePurchaseId());
					return purchaseRecordRepository.save(purchaseRecord);
				}).orElseThrow(()-> new SupplierNotFoundException("supplier not found with id = "  + supplierId));
		return new ResponseEntity<PurchaseRecord>(purchaseRecord,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<PurchaseRecord>> getAllSalesRecordsByCustomerId(Long supplierId)
			throws SupplierNotFoundException {
		if(!supplierRepository.existsSupplierBySupplierId(supplierId)) {
			throw new SupplierNotFoundException("supplier not found with id = " + supplierId);
			}
			List<PurchaseRecord> purchases = purchaseRecordRepository.findBySupplier_SupplierId(supplierId);
			return new ResponseEntity<List<PurchaseRecord>>(purchases,HttpStatus.OK);
	}

	@Override
	public PurchaseRecord updatePurchaseById(String purchaseId, PurchaseRecord purchaseRecord)
			throws PurchaseRecordNotFoundException {
		PurchaseRecord existingPurchaseRecord = purchaseRecordRepository.findByPurchaseId(purchaseId).orElseThrow(() -> new PurchaseRecordNotFoundException("Purchase Record not found with the purchaseId: "+purchaseId));
		existingPurchaseRecord.setAmountPaid(purchaseRecord.getAmountPaid());
		existingPurchaseRecord.setAmountToPay(purchaseRecord.getAmountToPay());
		existingPurchaseRecord.setBookISBN(purchaseRecord.getBookISBN());
		existingPurchaseRecord.setNoOfCopies(purchaseRecord.getNoOfCopies());
		existingPurchaseRecord.setPurchaseNoteNo(purchaseRecord.getPurchaseNoteNo());
		existingPurchaseRecord.setBalance(purchaseRecord.getBalance());
		existingPurchaseRecord.setSupplier(purchaseRecord.getSupplier());
		purchaseRecordRepository.save(existingPurchaseRecord);
		return existingPurchaseRecord;
	}

	@Override
	public BookPurchaseRecordDto getPurchaseRecordByBookISBN(Long bookISBN) throws PurchaseRecordNotFoundException {
		Book book = bookRepository.getById(bookISBN);
		List<PurchaseRecord> purchaseRecords =  purchaseRecordRepository.findPurchaseRecordByBookISBN(bookISBN);
	
		BookPurchaseRecordDto bookPurchaseRecordDto = new BookPurchaseRecordDto();
		bookPurchaseRecordDto.setBookISBN(bookISBN);
		bookPurchaseRecordDto.setBookName(book.getBookName());
		bookPurchaseRecordDto.setAuthor(book.getAuthor());
		bookPurchaseRecordDto.setPrice(book.getPrice());
		List<PurchaseRecordDto> purchaseRecordDtos = new ArrayList<PurchaseRecordDto>(); 
		purchaseRecords.forEach(purchaseRecord ->  {
			PurchaseRecordDto purchaseRecordDto = new PurchaseRecordDto();
			purchaseRecordDto.setPurchaseId(purchaseRecord.getPurchaseId());
			purchaseRecordDto.setAmountPaid(purchaseRecord.getAmountPaid());
			purchaseRecordDto.setAmountToPay(purchaseRecord.getAmountToPay());
			purchaseRecordDto.setPurchaseNoteNo(purchaseRecord.getPurchaseNoteNo());
			purchaseRecordDtos.add(purchaseRecordDto);
		});
		bookPurchaseRecordDto.setPurchaseRecordDto(purchaseRecordDtos);
		
		return bookPurchaseRecordDto;
	}


}
