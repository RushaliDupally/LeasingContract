package com.allane.contract.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Contains the Vehicle Details")
@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes = "Unique Identification Number of the Vehicle")
	public Long vin;

	@Column
	@ApiModelProperty(notes = "Brand Name of the Vehicle")
	public String brand;

	@Column
	@ApiModelProperty(notes = "Model Name of the Vehicle")
	public String model;

	@Column
	@ApiModelProperty(notes = "Year of the Vehicle")
	public Integer year;

	@Column
	@ApiModelProperty(notes = "Price of the Vehicle")
	public Double price;

	public Vehicle() {
		super();
	}

	public Vehicle(Long vin, String brand, String model, Integer year, Double price) {
		super();
		this.vin = vin;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public Long getVin() {
		return vin;
	}

	public void setVin(Long vin) {
		this.vin = vin;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
