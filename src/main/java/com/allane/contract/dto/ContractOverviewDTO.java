package com.allane.contract.dto;

public class ContractOverviewDTO {

	private Long contractNumber;
	private String customerName;
	private String vehicleName;
	private Long vin;
	private Double monthlyRate;
	private Double vehiclePrice;
	
	public Long getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(Long contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Long getVin() {
		return vin;
	}
	public void setVin(Long vin) {
		this.vin = vin;
	}
	public Double getMonthlyRate() {
		return monthlyRate;
	}
	public void setMonthlyRate(Double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}
	public Double getVehiclePrice() {
		return vehiclePrice;
	}
	public void setVehiclePrice(Double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
	
	
	
	
}
