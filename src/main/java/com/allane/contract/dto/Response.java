package com.allane.contract.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Response<T> {
	public T payload;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	public LocalDateTime timeStamp;
	public String transactionId;
	
	
	public Response(T payload, LocalDateTime timeStamp, String transactionId) {
		super();
		this.payload = payload;
		this.timeStamp = timeStamp;
		this.transactionId = transactionId;
	}
	
	
	public T getPayload() {
		return payload;
	}
	public void setPayload(T payload) {
		this.payload = payload;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
	
	
	
//	public Response(T payload, Date timeStamp, String transactionId) {
//		super();
//		LocalDateTime.now().format(new SimpleDateFormat(transactionId));
//		this.payload = payload;
//		this.timeStamp = timeStamp;
//		this.transactionId = transactionId;
//	}
//	
//	public T getPayload() {
//		return payload;
//	}
//	public void setPayload(T payload) {
//		this.payload = payload;
//	}
//	public Date getTimeStamp() {
//		return timeStamp;
//	}
//	public void setTimeStamp(Date timeStamp) {
//		this.timeStamp = timeStamp;
//	}
//	public String getTransactionId() {
//		return transactionId;
//	}
//	public void setTransactionId(String transactionId) {
//		this.transactionId = transactionId;
//	}
	
	

}
