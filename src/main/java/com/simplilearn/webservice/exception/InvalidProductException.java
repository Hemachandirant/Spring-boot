package com.simplilearn.webservice.exception;

public class InvalidProductException extends RuntimeException{

	
	private static final long serialVersionUID = -4302169068207426173L;
	
	public InvalidProductException(String message) {
		super(message);
	}

}
