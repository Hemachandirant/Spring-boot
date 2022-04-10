package com.simplilearn.webservice.exception;

public class InvalidCustomerDetails extends RuntimeException{

	

	private static final long serialVersionUID = -3186102746615728286L;

	public InvalidCustomerDetails(String message) {
		super(message);
	}
}
