package com.mouritech.onlinebookstoremanagement.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class BookPurchaseRecordDto {

	private Long bookISBN;
	private String bookName;
	private String author;
	private double price;
	private List<PurchaseRecordDto> purchaseRecordDto;
}
