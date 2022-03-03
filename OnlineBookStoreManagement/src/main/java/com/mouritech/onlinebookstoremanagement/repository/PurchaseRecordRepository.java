package com.mouritech.onlinebookstoremanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinebookstoremanagement.entity.PurchaseRecord;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {

	Optional<PurchaseRecord> findByPurchaseId(String purchaseId);

	List<PurchaseRecord> findBySupplier_SupplierId(Long supplierId);

	List<PurchaseRecord> findPurchaseRecordByBookISBN(Long bookISBN);

}
