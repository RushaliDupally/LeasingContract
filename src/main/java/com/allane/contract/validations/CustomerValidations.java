package com.allane.contract.validations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.allane.contract.entity.Contract;
import com.allane.contract.entity.Customer;
import com.allane.contract.exceptions.BusinessException;
import com.allane.contract.repository.ContractRepository;
import com.allane.contract.repository.CustomerRepository;

@Component
public class CustomerValidations {


	@Autowired
	public GenericValidations genericValidations;
	
	@Autowired
	public ContractRepository contractRepository;
	
	@Autowired
	public CustomerRepository customerRepository;
	
	public BusinessException businessException;

	public boolean handleCustomerValidations(Customer customer) throws Exception{
		// Validations on First Name
		
		// Name cannot be empty
		if(customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
			throw new BusinessException("First Name", customer.getFirstName(), "First Name cannot be Empty. Please enter a valid input" , HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		// name cannot have special characters or number
		if(!genericValidations.handleSpecialCharectersValidation(customer.getFirstName())) {
			throw new BusinessException("First Name", customer.getFirstName(), "First Name field is having special charecter. Please enter a Valid Input" , HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		// cannot have more than 64 charecters
		if(genericValidations.handleLengthValidation(customer.getFirstName())) {
			throw new BusinessException("First Name", customer.getFirstName(), "First Name field is exceeding the maximum limit of 64 charecters. Please enter a Valid Input" , HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		
		// Validations on Last Name
		
		// name cannot have special characters or number
		if(!genericValidations.handleSpecialCharectersValidation(customer.getLastName())) {
			throw new BusinessException("Last Name", customer.getLastName(), "Last Name field is having special charecter. Please enter a Valid Input" , HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		
		// cannot have more than 64 characters
		if(genericValidations.handleLengthValidation(customer.getLastName())) {
			throw new BusinessException("Last Name", customer.getLastName(), "Last Name field is exceeding the maximum limit of 64 charecters. Please enter a Valid Input" , HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		
		// Validations on date of birth
		
		
		return true;
	}
	
	public boolean isCustomerAssignedToAContract(Long id) {
		Contract contract = contractRepository.getContractByCustomerId(id);
		if(contract != null) {
			String message = "The Customer you have selected cannot be deleted, since it is assigned to contract with Contract Number: " + contract.getContractNumber() +"." ;
			throw new BusinessException("Customer", "", message, HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return false;
	}
	
	public boolean hasARecordWithOid(Long oid) {
		Optional<Customer> customer = customerRepository.findById(oid);
		if(!customer.isPresent()) {
			throw new BusinessException("customerId", "", "There is no Customer present with the given Id. Please enter a valid Input", HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());
		}
		return customer.isPresent();
	}
	
	public boolean isValidToBeDeleted() {
		boolean isValidToBeDeleted = true;
		Long customerMapCount = contractRepository.getContractAndCustomerMapCount();
		if(customerMapCount > 0) {
			isValidToBeDeleted = false;
			throw new BusinessException("vin", "", "There are a few Customers assigned to a contract. Please unmap them and then perform the Delete Operation.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return isValidToBeDeleted;
	}
}
