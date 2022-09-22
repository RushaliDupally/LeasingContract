package com.allane.contract.validations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.allane.contract.entity.Contract;
import com.allane.contract.entity.Vehicle;
import com.allane.contract.exceptions.BusinessException;
import com.allane.contract.repository.ContractRepository;
import com.allane.contract.repository.VehicleRepository;

@Component
public class VehicleValidations {

	@Autowired
	public GenericValidations genericValidations;
	
	@Autowired
	public ContractRepository contractRepository;
	
	@Autowired
	public VehicleRepository vehicleRepository;
	
	
	public boolean handleVehicleValidations(Vehicle vehicle) {
		return isBrandNameValid(vehicle) && isModelNameValid(vehicle) && isYearValid(vehicle) && isPriceValid(vehicle);
	}
	
	public boolean isBrandNameValid(Vehicle vehicle) {
		if(vehicle.getBrand() == null || vehicle.getBrand().isEmpty()) {
			throw new BusinessException("Brand", vehicle.getBrand() , "Brand Name cannot be empty.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		if(!genericValidations.handleSpecialCharectersValidation(vehicle.getBrand())) {
			throw new BusinessException("Brand", vehicle.getBrand() , "Brand Name can have only Alphabets. Please enter a valid input.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		if(genericValidations.handleLengthValidation(vehicle.getBrand())) {
			throw new BusinessException("Brand", vehicle.getBrand() , "Brand Name cannot exceed 64 chracters. Please enter a valid input.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return true;
	}
	
	// model
	public boolean isModelNameValid(Vehicle vehicle) {
		if(vehicle.getModel() == null || vehicle.getModel().isEmpty()) {
			throw new BusinessException("Model", vehicle.getModel() , "Model Name cannot be empty.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		if(vehicle.getModel() == null || vehicle.getModel().isEmpty()) {
			throw new BusinessException("Model", vehicle.getModel() , "Model Name cannot be empty.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		if(genericValidations.handleLengthValidation(vehicle.getModel())) {
			throw new BusinessException("Model", vehicle.getModel() , "Model Name cannot exceed 64 chracters. Please enter a valid input.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return true;
	}
	
	// year
	public boolean isYearValid(Vehicle vehicle) {
		if (vehicle.getYear() == 0) {
			throw new BusinessException("Year", "", "Year cannot be empty.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		int length = String.valueOf(vehicle.getYear()).length();
		if(length != Constants.YEAR_LENGTH || vehicle.getYear() <= 0) {
			throw new BusinessException("Year", "", "Please enter a valid value for Year.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return true;
	}
	
	// price
	public boolean isPriceValid(Vehicle vehicle) {
		if(genericValidations.handleNegativeValidationsForDouble(vehicle.getPrice())) {
			throw new BusinessException("Price", "", "Price cannot be Zero or Negative. Please enter a valid value.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return true;
	}
	
	public boolean isVehicleAssignedToAContract(Long vin) {
		Contract contract = contractRepository.getContractByVin(vin);
		if(contract != null) {
			String message = "The Vehicle you have selected cannot be deleted, since it is assigned to contract with Contract Number: " + contract.getContractNumber() +"." ;
			throw new BusinessException("Vehicle", "", message, HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return false;
	}
	
	public boolean hasARecordWithOid(Long oid) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(oid);
		if(!vehicle.isPresent()) {
			throw new BusinessException("vin", "", "There is no Vehicle present with the given Id. Please enter a valid Input", HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());
		}
		return false;
	}
	
	public boolean isValidToBeDeleted() {
		Long vehicleMapCount = contractRepository.getContractAndVehicleMapCount();
		boolean isValidToBeDeleted = true;
		if (vehicleMapCount > 0) {
			isValidToBeDeleted = false;
			throw new BusinessException("vin", "", "There are a few Vehicles assigned to a contract. Please unmap them and then perform the Delete Operation.", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		return isValidToBeDeleted;
	}
}
