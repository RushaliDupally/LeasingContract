package com.allane.contract.exceptions;

public class EmptyFieldException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String errorCode;
	public String errorMessage;
	
	public EmptyFieldException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
