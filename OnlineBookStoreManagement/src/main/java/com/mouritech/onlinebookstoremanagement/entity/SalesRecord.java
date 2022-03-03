package com.mouritech.onlinebookstoremanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "SalesRecord")
@EntityListeners(AuditingEntityListener.class)
public class SalesRecord {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sales_Id", length = 64)
	private String salesId;
//	@Column(name="CustomerId")
//	private String customerId;
	@Column(name = "Invoice_No")
	private int invoiceNo;
	@Column(name = "Amount_To_Pay")
	private float amountToPay;
	@Column(name = "Amount_Paid")
	private float amountPaid;
	@Column(name = "Price")
	private double price;
	@Column(name = "No_Of_Copies")
	private int noOfCopies;
	@Column(name = "book_ISBN")
	private Long bookISBN;
	@Column(name = "Balance")
	private float balance;

	public SalesRecord() {
		// TODO Auto-generated constructor stub
	}

	public SalesRecord(String salesId, int invoiceNo, float amountToPay, float amountPaid, double price, int noOfCopies,
			Long bookISBN, float balance) {
		super();
		this.salesId = salesId;
		this.invoiceNo = invoiceNo;
		this.amountToPay = amountToPay;
		this.amountPaid = amountPaid;
		this.price = price;
		this.noOfCopies = noOfCopies;
		this.bookISBN = bookISBN;
		this.balance = balance;
	}

	public SalesRecord(int invoiceNo, float amountToPay, float amountPaid, double price, int noOfCopies,
			Long bookISBN, float balance) {
		super();
		this.invoiceNo = invoiceNo;
		this.amountToPay = amountToPay;
		this.amountPaid = amountPaid;
		this.price = price;
		this.noOfCopies = noOfCopies;
		this.bookISBN = bookISBN;
		this.balance = balance;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customer_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	// @Column(insertable = false, updatable = false)

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "SalesRecord [salesId=" + salesId + ", invoiceNo=" + invoiceNo + ", amountToPay=" + amountToPay
				+ ", amountPaid=" + amountPaid + ", price=" + price + ", noOfCopies=" + noOfCopies + ", bookISBN="
				+ bookISBN + ", balance=" + balance + "]";
	}

}