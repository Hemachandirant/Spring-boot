package com.simplilearn.webservice.exception;

public class ProductNotFound extends RuntimeException {
	
	
	private static final long serialVersionUID = -5672946110623434509L;

	public ProductNotFound(String message) {
		super(message);
	}

}
