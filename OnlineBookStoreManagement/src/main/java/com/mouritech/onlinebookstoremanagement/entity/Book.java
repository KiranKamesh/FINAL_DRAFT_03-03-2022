package com.mouritech.onlinebookstoremanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookISBN")
	private Long bookISBN;
	@Column(name = "bookName")
	private String bookName;
	@Column(name = "author")
	private String author;
	@Column(name = "price")
	private double price;
	@Column(name = "noofCopies")
	private int noOfCopies;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Long getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(Long bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public Book(String bookName, String author, double price, int noOfCopies) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.noOfCopies = noOfCopies;
	}

	@Override
	public String toString() {
		return "Book [bookISBN=" + bookISBN + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", noOfCopies=" + noOfCopies + "]";
	}

}