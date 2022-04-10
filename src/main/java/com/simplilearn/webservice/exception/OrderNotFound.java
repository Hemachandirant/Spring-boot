package com.simplilearn.webservice.exception;

public class OrderNotFound  extends RuntimeException{


	private static final long serialVersionUID = 2491156914011346526L;
	
	public OrderNotFound(String message) {
		super(message);
	}
	

}
