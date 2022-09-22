package com.allane.contract.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.allane.contract.dto.ContractDetailsFormDTO;
import com.allane.contract.dto.ContractOverviewDTO;
import com.allane.contract.dto.Response;
import com.allane.contract.entity.Contract;
import com.allane.contract.service.ContractService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/contract")
public class ContractController {
	
	Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	public ContractService contractService;

	@PostMapping("/save")
	@ApiOperation(value = "Save the Contract Data",
	notes = "Provide Contract Payload to save the data. Request Method: POST",
	response = Contract.class)
	public ResponseEntity<Response> saveContract(@RequestBody Contract contract) throws Exception{
		logger.debug("ContractController.saveContract Started");
		String transactionId = UUID.randomUUID().toString();
		Contract newContract = contractService.saveContract(contract);
		Response response = new Response(newContract, LocalDateTime.now(), transactionId);
		logger.debug("ContractController.saveContract Ended Successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	@ApiOperation(value = "Get Contract By Id",
	notes = "Provide a contract to look up for a specific ID. Request Method: GET",
	response = Contract.class)
	public ResponseEntity<Response> getById(@ApiParam(value = "ID Value for the contract you need to Retreive", required = true) @PathVariable("id") Long id) {
		logger.debug("ContractController.saveContract Ended Successfully");
		String transactionId = UUID.randomUUID().toString();
		Contract contract = contractService.getContractById(id);
		Response response = new Response(contract, LocalDateTime.now(), transactionId);
		logger.debug("ContractController.saveContract Ended Successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/getAllContracts")
	@ApiOperation(value = "Get All Contracts",
				notes = "Get All Contracts. Request Method: GET",
				response = ResponseEntity.class)
	public ResponseEntity<Response> getAllContracts() {
		logger.debug("ContractController.saveContract Ended Successfully");
		String transactionId = UUID.randomUUID().toString();
		List<ContractOverviewDTO> contractList =  contractService.getAllContracts();
		Response response = new Response(contractList, LocalDateTime.now(), transactionId);
		logger.debug("ContractController.saveContract Ended Successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete Contract By Id",
	notes = "Deletes the Contract Information based on the ID. Request Method: DELETE",
	response = ResponseEntity.class)
	public ResponseEntity deleteById(@PathVariable("id") Long contractNumber) {
		logger.debug("ContractController.saveContract Ended Successfully");
		contractService.deleteById(contractNumber);
		logger.debug("ContractController.saveContract Ended Successfully");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	@ApiOperation(value = "Delete All Contracts",
	notes = "Deletes All Contracts. Request Method: GET",
	response = ResponseEntity.class)
	public ResponseEntity deleteAll() {
		logger.debug("ContractController.saveContract Ended Successfully");
		contractService.deleteAll();
		logger.debug("ContractController.saveContract Ended Successfully");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getDropdownDetails")
	@ApiOperation(value = "Get Dropddown Data",
	notes = "Gets the Customer and Vehicle Dropdown data. Request Method: GET",
	response = ContractDetailsFormDTO.class)
	public ResponseEntity<Response> getDropdownDetails() throws Exception{
		String transactionId = UUID.randomUUID().toString();
		ContractDetailsFormDTO contractDetailsForm = contractService.getDropdownDetails();
		Response response = new Response(contractDetailsForm, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/unMapCustomer/{id}")
	@ApiOperation(value = "Unmap Customer",
	notes = "Un maps Customer from the contract. Request Method: DELETE",
	response = ResponseEntity.class)
	public ResponseEntity<Response> unMapCustomerFromContract(@PathVariable("id") Long contractNumber) throws Exception{
		contractService.unMapCustomerFromContract(contractNumber);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/unMapVehicle/{id}")
	@ApiOperation(value = "Unmap Vehicle",
	notes = "Un maps Vehicle from the contract. Request Method: DELETE",
	response = ResponseEntity.class)
	public ResponseEntity<Response> unMapVehicleFromContract(@PathVariable("id") Long contractNumber) throws Exception{
		contractService.unMapVehicleFromContract(contractNumber);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Update Contract",
	notes = "Update Contract based on Contract ID. Request Method: PUT",
	response = ResponseEntity.class)
	public ResponseEntity<Response> updateContract(@PathVariable("id") Long contractNumber, @RequestBody Contract payload) throws Exception{
		String transactionId = UUID.randomUUID().toString();
		Contract contract = contractService.updateContract(contractNumber, payload);
		Response response = new Response(contract, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
}
