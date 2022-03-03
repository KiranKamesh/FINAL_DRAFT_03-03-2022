package com.mouritech.onlinebookstoremanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mouritech.onlinebookstoremanagement.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	//Optional<Supplier> findBySupplierId(String supplierId);

	Optional<Supplier> findBySupplierId(Long supplierId);

	boolean existsSupplierBySupplierId(Long supplierId);

}
