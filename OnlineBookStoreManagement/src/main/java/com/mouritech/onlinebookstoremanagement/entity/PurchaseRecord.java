package com.mouritech.onlinebookstoremanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "PurchaseRecord")
public class PurchaseRecord {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id", length = 64)
	private String purchaseId;
//	@Column(name = "Supplier_Id")
//	private String supplierId;
	@Column(name = "Purchase_Note_No")
	private int purchaseNoteNo;
	@Column(name = "Amount_To_Pay")
	private float amountToPay;
	@Column(name = "Amount_Paid")
	private float amountPaid;
	@Column(name = "Balance")
	private float balance;
	@Column(name = "No_Of_Copies")
	private int noOfCopies;
	@Column(name = "book_ISBN")
	private Long bookISBN;

	public PurchaseRecord() {
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "supplier_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	// @Column(insertable = false, updatable = false)

	private Supplier supplier;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public PurchaseRecord(String purchaseId, int purchaseNoteNo, float amountToPay, float amountPaid,
			float balance, int noOfCopies, Long bookISBN) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseNoteNo = purchaseNoteNo;
		this.amountToPay = amountToPay;
		this.amountPaid = amountPaid;
		this.balance = balance;
		this.noOfCopies = noOfCopies;
		this.bookISBN = bookISBN;
	}

	public PurchaseRecord(int purchaseNoteNo, float amountToPay, float amountPaid, float balance,
			int noOfCopies, Long bookISBN) {
		super();
		this.purchaseNoteNo = purchaseNoteNo;
		this.amountToPay = amountToPay;
		this.amountPaid = amountPaid;
		this.balance = balance;
		this.noOfCopies = noOfCopies;
		this.bookISBN = bookISBN;
	}

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}


	public int getPurchaseNoteNo() {
		return purchaseNoteNo;
	}

	public void setPurchaseNoteNo(int purchaseNoteNo) {
		this.purchaseNoteNo = purchaseNoteNo;
	}

	public float getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(float amountToPay) {
		this.amountToPay = amountToPay;
	}

	public float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public Long getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(Long bookISBN) {
		this.bookISBN = bookISBN;
	}

	@Override
	public String toString() {
		return "PurchaseRecord [purchaseId=" + purchaseId + ", purchaseNoteNo="
				+ purchaseNoteNo + ", amountToPay=" + amountToPay + ", amountPaid=" + amountPaid + ", balance="
				+ balance + ", noOfCopies=" + noOfCopies + ", bookISBN=" + bookISBN + "]";
	}

}
