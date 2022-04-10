package com.simplilearn.webservice.exception;

public class CustomerAlreadyExist extends RuntimeException {

	private static final long serialVersionUID = 2273177752521481732L;

	public CustomerAlreadyExist(String message) {
		super(message);
	}

}
