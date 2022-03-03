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

import com.mouritech.onlinebookstoremanagement.entity.Supplier;
import com.mouritech.onlinebookstoremanagement.exception.SupplierNotFoundException;
import com.mouritech.onlinebookstoremanagement.service.SupplierService;

@RestController
@RequestMapping("supplier/api/v1")
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@PostMapping("/supplier")
	public ResponseEntity<?> saveSupplier(@RequestBody Supplier newSupplier) {
		supplierService.insertSupplier(newSupplier);
		return ResponseEntity.ok().body("new supplier added successfully");
	}

	@GetMapping("/supplier")
	public List<Supplier> getAllSuppliers() {
		return supplierService.showAllSuppliers();


	}

	// get a customer by id
	@GetMapping("supplier/{sid}")
	public Supplier showSupplierById(@PathVariable("sid") Long supplierId) throws SupplierNotFoundException {
		return supplierService.showSupplierById(supplierId);
	}

	// update a customer
	@PutMapping("supplier/{sid}")
	public Supplier updateSupplierById(@PathVariable("sid") Long supplierId, @RequestBody Supplier supplier)
			throws SupplierNotFoundException {
		return supplierService.updateSupplierById(supplierId, supplier);

	}

	@DeleteMapping("supplier/{sid}")
	public String deleteSupplierById(@PathVariable("sid") Long supplierId) throws SupplierNotFoundException {
		supplierService.deleteSupplierById(supplierId);
		return "supplier deleted";

	}
}
