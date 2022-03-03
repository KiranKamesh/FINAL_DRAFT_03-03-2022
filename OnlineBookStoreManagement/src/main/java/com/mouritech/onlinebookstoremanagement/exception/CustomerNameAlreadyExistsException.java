package com.mouritech.onlinebookstoremanagement.exception;

public class CustomerNameAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerNameAlreadyExistsException(String msg) {
		super(msg);
	}

}
