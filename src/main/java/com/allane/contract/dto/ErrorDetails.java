package com.allane.contract.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {

	private Date timeStamp;
	private String message;
	private String detail;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd hh:mm:ss")
	private LocalDateTime date;
	private Integer statusCode;

	public ErrorDetails(Date timeStamp, String message, String detail, LocalDateTime date, Integer statusCode) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.detail = detail;
		this.date = date;
		this.statusCode = statusCode;
	}

//	public ErrorDetails(Date timeStamp, String message, String detail, LocalDateTime date) {
//		super();
//		this.timeStamp = timeStamp;
//		this.message = message;
//		this.detail = detail;
//		this.date = LocalDateTime.now();
//	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
