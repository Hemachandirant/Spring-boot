package com.simplilearn.webservice.exception;

public class ProductAlreadyExist extends RuntimeException{

	
	private static final long serialVersionUID = -2374373393194009905L;
	
	public ProductAlreadyExist(String message) {
		super(message);
	}
	

}
