package com.allane.contract.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allane.contract.dto.Response;
import com.allane.contract.entity.Customer;
import com.allane.contract.entity.Vehicle;
import com.allane.contract.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	@PostMapping("/save")
	@ApiOperation(value = "Save Customer Data",
	notes = "Save Customer Data based on Customer payload. Request Method: POST",
	response = Customer.class)
	public ResponseEntity<Response> saveCustomer(@RequestBody Customer customer) throws Exception{
		String transactionId = UUID.randomUUID().toString();
		Customer addedCustomer = customerService.saveCustomerData(customer);
		Response response = new Response(addedCustomer, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	@ApiOperation(value = "Get Customer Data on id",
	notes = "Get Customer data based on Id. Request Method: GET",
	response = Customer.class)
	public ResponseEntity<Response> getById(@PathVariable("id") Long id) throws Exception{
		String transactionId = UUID.randomUUID().toString();
		Customer customer =  customerService.getCustomerById(id);
		Response response = new Response(customer, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	@ApiOperation(value = "Get Customer Data List",
	notes = "Get all Customer Details. Request Method: GET",
	response = Customer.class)
	public ResponseEntity<Response> getCustomerList() throws Exception{
		String transactionId = UUID.randomUUID().toString();
		List<Customer> custList =  customerService.getCustomerList();
		Response response = new Response(custList, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete Customer Data on ID",
	notes = "Delete Based on ID. Request Method: DELETE",
	response = ResponseEntity.class)
	public ResponseEntity deleteById(@PathVariable Long id) throws Exception{
		customerService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@DeleteMapping("/deleteAll")
	@ApiOperation(value = "Delete the whole Customer Data",
	notes = "Delete the whole Customer Data. Request Method: DELETE",
	response = ResponseEntity.class)
	public ResponseEntity deleteAll() throws Exception{
		customerService.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Update the whole Customer Data",
	notes = "Update the Customer Data based on id. Request Method: PUT",
	response = Customer.class)
	public ResponseEntity<Response> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) throws Exception{
		String transactionId = UUID.randomUUID().toString();
		Customer newCustomer =  customerService.updateCustomerData(id, customer);
		Response response = new Response(newCustomer, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
	} 
	
	
	
}
