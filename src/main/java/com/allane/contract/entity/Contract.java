package com.allane.contract.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the contract")
@Entity(name = "contract")
@Table(name = "contract")
public class Contract {
	
	@Id
	@Column
	@ApiModelProperty(notes = "Unique ID of the Contract Number")
	public Long contractNumber;
	
	@Column
	@ApiModelProperty(notes = "Monthly rate of the Contract")
	public Double monthlyRate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_vin")
	@ApiModelProperty(notes = "Vehicle assigned to the contract")
	public Vehicle vehicle;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_oid")
	@ApiModelProperty(notes = "Customer assiged to the Contract")
	public Customer customer;

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(Long contractNumber, Double monthlyRate, Vehicle vehicle, Customer customer) {
		super();
		this.contractNumber = contractNumber;
		this.monthlyRate = monthlyRate;
		this.vehicle = vehicle;
		this.customer = customer;
	}

	public Long getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(Long contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(Double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	

}
