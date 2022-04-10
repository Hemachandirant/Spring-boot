package com.simplilearn.webservice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simplilearn.webservice.exception.CustomerAlreadyExist;
import com.simplilearn.webservice.exception.CustomerNotFound;
import com.simplilearn.webservice.exception.InvalidCustomerDetails;
import com.simplilearn.webservice.exception.InvalidOrderException;
import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.OrderAlreadyExist;
import com.simplilearn.webservice.exception.OrderNotFound;
import com.simplilearn.webservice.exception.ProductAlreadyExist;
import com.simplilearn.webservice.exception.ProductNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	ExceptionResponse response;
	
	
	//ProductNotFound
	@ExceptionHandler(value=ProductNotFound.class)
	public ResponseEntity<ExceptionResponse> notFoundException(ProductNotFound ex){
		response = new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	//ProductAlreadyExist 
	@ExceptionHandler(value=ProductAlreadyExist.class)
	public ResponseEntity<ExceptionResponse> productAlreadyExists(ProductAlreadyExist ex){
		response = new ExceptionResponse(ex.getMessage(),HttpStatus.NOT_FOUND.name(),ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	// Product Already Exist Exception
		@ExceptionHandler(value = InvalidProductException.class)
		public ResponseEntity<ExceptionResponse> invalidException(InvalidProductException ex) {
			response = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.name(), ex.getClass().getSimpleName());
			return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
	//orderNotFound
	@ExceptionHandler(value=OrderNotFound.class)
	public ResponseEntity<ExceptionResponse> orderNotFound(OrderNotFound ex){
		response = new ExceptionResponse(ex.getMessage(),HttpStatus.NOT_FOUND.name(),ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	//OrderAlreadyExist
	@ExceptionHandler(value=OrderAlreadyExist.class)
	public ResponseEntity<ExceptionResponse> orderAlreadyExists(OrderAlreadyExist ex){
		response = new ExceptionResponse(ex.getMessage(),HttpStatus.NOT_FOUND.name(),ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	//InvalidOrder
	@ExceptionHandler(value=InvalidOrderException.class)
	public ResponseEntity<ExceptionResponse> invalidOrder(InvalidOrderException ex){
		response = new ExceptionResponse(ex.getMessage(),HttpStatus.NOT_FOUND.name(),ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	//Invalid Customer
	@ExceptionHandler(value=InvalidCustomerDetails.class)
	public ResponseEntity<ExceptionResponse> invalidCustomer(InvalidCustomerDetails ex){
		response = new ExceptionResponse(ex.getMessage(),HttpStatus.NOT_FOUND.name(),ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	//CustomerAlreadyExists
	@ExceptionHandler(value=CustomerAlreadyExist.class)
	public ResponseEntity<ExceptionResponse> customerAlreadyExists(CustomerAlreadyExist ex){
		response = new ExceptionResponse(ex.getMessage(),HttpStatus.NOT_FOUND.name(),ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	//CustomerNotFound
	@ExceptionHandler(value=CustomerNotFound.class)
	public ResponseEntity<ExceptionResponse> customerAlreadyFound(CustomerNotFound ex){
		response = new ExceptionResponse(ex.getMessage(),HttpStatus.NOT_FOUND.name(),ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
}
