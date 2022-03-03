package com.mouritech.onlinebookstoremanagement.dto.response;

import lombok.Data;

@Data
public class SalesRecordDto {
	private String salesId;
	private int invoiceNo;
	private float amountToPay;
	private float amountPaid;

}
