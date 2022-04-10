package com.simplilearn.webservice.exception;

public class CustomerNotFound extends RuntimeException{
	

	private static final long serialVersionUID = 3043577741840484500L;

	public CustomerNotFound(String message) {
		super(message);
	}

}
