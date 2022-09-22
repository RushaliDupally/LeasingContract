package com.allane.contract.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.allane.contract.dto.ErrorDetails;
import com.allane.contract.dto.ErrorResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;


@ControllerAdvice
public class GlobalExceptionHandler{
	 

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyResultDataException(WebRequest req, EmptyResultDataAccessException ex) {
		String message = "There is no record found with the ID entered.";
		ErrorDetails errorDetails = new ErrorDetails(new Date(), message, req.getDescription(false), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<?> handleInvalidFormatException(WebRequest req, InvalidFormatException ex) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), req.getDescription(false), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> handeSQLIntegrityConstraintViolationException(HttpServletRequest req,
			SQLIntegrityConstraintViolationException ex) {
		String error = "Unable to submit request " + ex.getMessage();
		return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, LocalDateTime.now(), error));
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleNoSuchElementException(WebRequest req, NoSuchElementException ex) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), req.getDescription(false), LocalDateTime.now(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<?> handleEmptyFieldException(WebRequest req, EmptyFieldException ex) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getErrorMessage(), req.getDescription(false), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(WebRequest req, BusinessException ex) {
		BusinessException businessException = new BusinessException(ex.getFieldName(), ex.getFieldValue(), ex.getMessage(), ex.getResponseCode(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity(businessException, HttpStatus.BAD_REQUEST);
	}
	

	public ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
		return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
	}
}
