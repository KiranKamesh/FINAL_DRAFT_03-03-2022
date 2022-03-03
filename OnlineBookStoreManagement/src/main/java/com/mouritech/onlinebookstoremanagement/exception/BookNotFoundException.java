package com.mouritech.onlinebookstoremanagement.exception;

public class BookNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String msg) {
		super(msg);
	}

}
