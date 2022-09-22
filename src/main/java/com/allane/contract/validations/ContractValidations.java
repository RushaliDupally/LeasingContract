package com.allane.contract.validations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.allane.contract.entity.Contract;
import com.allane.contract.entity.Vehicle;
import com.allane.contract.exceptions.BusinessException;
import com.allane.contract.repository.ContractRepository;

@Service
public class ContractValidations {

	@Autowired
	public GenericValidations genericValidations;
	
	@Autowired
	public ContractRepository contractRepository;
	
	public boolean isValidMonthlyRate(Contract contract) {
		if(genericValidations.handleNegativeValidationsForDouble(contract.getMonthlyRate())) {
			throw new BusinessException("Monthly rate", "", "Monthly Rate cannot be 0 or Negative. Please enter a valid Input", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return true;
	}
	
	public boolean isValidContract(Contract contract) throws Exception {
		if(hasNonUniqueContractNumber(contract)) {
			throw new BusinessException("Contract Number", "", "Contract Number should be a Unique value. Please enter a valid Input", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		
		if(isVehicleAssignedToAnotherContract(contract)) {
			Vehicle vehicle = contract.getVehicle();
			throw new BusinessException("Vehicle", "", "The Vehicle you have selected " + vehicle.getBrand() + " (" + vehicle.getModel() +") is already assigned to another contract. Please select Another Vehicle." , HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}		
		return true;
	}
	
	
	// unique contract
	public boolean hasNonUniqueContractNumber(Contract contract) {
		boolean hasNonUniqueContractNumber = false;
		Optional<Contract> contractDetails = contractRepository.findById(contract.getContractNumber());
		if(contractDetails.isPresent()) {
			hasNonUniqueContractNumber = true;
		}
		return hasNonUniqueContractNumber;
	}
	
	
	// vehicle already assigned to another contract
	public boolean isVehicleAssignedToAnotherContract(Contract contract) {
		Long count = contractRepository.getContractsOnVin(contract.getVehicle().getVin());
		boolean isAssigned = count>0 ? true :false;
		return isAssigned;
	}
	
	// contract already assigned to the customer
	public boolean isCustomerAssignedToAnotherContract(Contract contract) {
		Long count = contractRepository.getContractsOnCustomerId(contract.getCustomer().getId());
		boolean isAssigned = count>0 ? true :false;
		return isAssigned;
	}
	
	public boolean hasARecordWithOid(Long oid) {
		Optional<Contract> contract = contractRepository.findById(oid);
		if(!contract.isPresent()) {
			throw new BusinessException("Contract Id", "", "There is no contract present with the given Id. Please enter a valid Input", HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());
		}
		return contract.isPresent();
	}
}
