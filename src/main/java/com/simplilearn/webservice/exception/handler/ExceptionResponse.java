package com.simplilearn.webservice.exception.handler;

import java.util.Date;

public class ExceptionResponse {
	
	private String message;
	private String error;
	private String status;
	private Date timestamp;
	public ExceptionResponse(String message, String error, String status) {
		super();
		this.message = message;
		this.error = error;
		this.status = status;
		this.timestamp = new Date();
	}
	public ExceptionResponse() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
