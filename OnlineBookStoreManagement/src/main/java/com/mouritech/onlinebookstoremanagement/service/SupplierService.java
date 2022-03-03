package com.mouritech.onlinebookstoremanagement.service;

import java.util.List;

import com.mouritech.onlinebookstoremanagement.entity.Supplier;
import com.mouritech.onlinebookstoremanagement.exception.SupplierNotFoundException;

public interface SupplierService {

	Supplier insertSupplier(Supplier newSupplier);

	List<Supplier> showAllSuppliers();

	Supplier showSupplierById(Long supplierId) throws SupplierNotFoundException;

	Supplier updateSupplierById(Long supplierId, Supplier supplier) throws SupplierNotFoundException;

	void deleteSupplierById(Long supplierId) throws SupplierNotFoundException;
	
	
}
