package com.simplilearn.webservice.exception;

public class OrderAlreadyExist extends RuntimeException{
	
	
	private static final long serialVersionUID = -6608146621635146324L;

	public OrderAlreadyExist(String message) {
		super(message);
	}

}
