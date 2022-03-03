package com.mouritech.onlinebookstoremanagement.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlinebookstoremanagement.entity.Supplier;
import com.mouritech.onlinebookstoremanagement.exception.SupplierNotFoundException;
import com.mouritech.onlinebookstoremanagement.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public Supplier insertSupplier(Supplier newSupplier) {
		return supplierRepository.save(newSupplier);
		
	}
	


	@Override
	public List<Supplier> showAllSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier showSupplierById(Long supplierId) throws SupplierNotFoundException{
		return supplierRepository.findBySupplierId(supplierId).orElseThrow(() -> new SupplierNotFoundException("The folowing supplier with the id is not found"));
		
	}

	@Override
	public Supplier updateSupplierById(Long supplierId, Supplier supplier) throws SupplierNotFoundException {
		Supplier exisitingSupplier = supplierRepository.findBySupplierId(supplierId).orElseThrow(() -> new SupplierNotFoundException("The following supplier with the id is not found"));
		exisitingSupplier.setSupplierName(supplier.getSupplierName());
		exisitingSupplier.setSupplierAddress(supplier.getSupplierAddress());;
		exisitingSupplier.setSupplierContactNo(supplier.getSupplierContactNo());
		exisitingSupplier.setSupplierEmailId(supplier.getSupplierEmailId());
		return supplierRepository.save(exisitingSupplier);
	}

	@Override
	public void deleteSupplierById(Long supplierId) throws SupplierNotFoundException{
		Supplier existingSupplier = supplierRepository.findBySupplierId(supplierId).orElseThrow(() -> new SupplierNotFoundException("The following supplier with the id is not found"));
		supplierRepository.delete(existingSupplier);

	}

}
