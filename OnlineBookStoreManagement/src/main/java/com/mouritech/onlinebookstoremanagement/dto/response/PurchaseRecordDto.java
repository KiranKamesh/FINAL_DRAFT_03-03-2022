package com.mouritech.onlinebookstoremanagement.dto.response;

import lombok.Data;

@Data
public class PurchaseRecordDto {
	private String purchaseId;
	private int purchaseNoteNo;
	private float amountToPay;
	private float amountPaid;


}
