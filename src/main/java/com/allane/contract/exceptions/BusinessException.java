package com.allane.contract.exceptions;

import org.springframework.http.HttpStatus;


public class BusinessException extends RuntimeException{
	
	
	private String fieldName;
	private String fieldValue;
	private String message;
	private HttpStatus responseCode;
	private Integer statusCode;	
	
	public BusinessException(String fieldName, String fieldValue, String message, HttpStatus responseCode,
			Integer statusCode) {
		super();
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.message = message;
		this.responseCode = responseCode;
		this.statusCode = statusCode;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
}
