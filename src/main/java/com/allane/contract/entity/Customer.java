package com.allane.contract.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity(name = "customer")
@Table(name = "customer")
@ApiModel(description = "Contains the Customer Details")
public class Customer {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Contains Unique ID of the Customer")
	public long id;

	@Column
	@ApiModelProperty(notes = "First Name of the Customer")
	public String firstName;

	@Column
	@ApiModelProperty(notes = "Last Name of the Customer")
	public String lastName;

	@Column
	public Date dob;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long id, String firstName, String lastName, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public Customer(String firstName, String lastName, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
