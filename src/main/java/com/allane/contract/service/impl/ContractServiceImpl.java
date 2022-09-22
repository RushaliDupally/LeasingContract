package com.allane.contract.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allane.contract.dto.ContractDetailsFormDTO;
import com.allane.contract.dto.ContractOverviewDTO;
import com.allane.contract.dto.DropdownDTO;
import com.allane.contract.entity.Contract;
import com.allane.contract.entity.Customer;
import com.allane.contract.entity.Vehicle;
import com.allane.contract.repository.ContractRepository;
import com.allane.contract.repository.CustomerRepository;
import com.allane.contract.repository.VehicleRepository;
import com.allane.contract.service.ContractService;
import com.allane.contract.validations.ContractValidations;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	public ContractRepository contractRepository;

	@Autowired
	public VehicleRepository vehicleRepository;

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public ContractValidations contractValidations;

	@Override
	public Contract saveContract(Contract contract) throws Exception {
		if (contractValidations.isValidContract(contract) && contractValidations.isValidMonthlyRate(contract)) {
			return contractRepository.save(contract);
		}
		return null;
	}

	@Override
	public Contract getContractById(Long id) {
		return contractRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
				"There is no element existent with this Id " + HttpStatus.BAD_REQUEST));
	}

	@Override
	public List<ContractOverviewDTO> getAllContracts() {
		 List<Contract> contractList = contractRepository.findAll();
		 List<ContractOverviewDTO> contractOverviewList = new ArrayList<ContractOverviewDTO>();
		 if(!contractList.isEmpty()) {
			 for(Contract contract: contractList) {
				 ContractOverviewDTO contractOverview = new ContractOverviewDTO();
				 contractOverview.setContractNumber(contract.getContractNumber());
				 contractOverview.setMonthlyRate(contract.getMonthlyRate());
				 Customer customerData = contract.getCustomer();
				 if(customerData != null) {
					 String name = customerData.getFirstName() + ((customerData.getLastName() != null && customerData.getLastName().trim() != "") ? (" " + customerData.getLastName()) : "");
					 name = isNotEmpty(name) ? name : "-";
					 contractOverview.setCustomerName(name);
				 }
				 Vehicle vehicleData = contract.getVehicle();
				 if(vehicleData != null) {
					 contractOverview.setVin(vehicleData.getVin());
					 contractOverview.setVehiclePrice(vehicleData.getPrice());
					 String vehicleName = vehicleData.getBrand() + (isNotEmpty(vehicleData.getModel()) ? (" " + vehicleData.getModel()) : "")+ (vehicleData.getYear() != null ? ("(" + vehicleData.getYear() +")") : "");
					 vehicleName = isNotEmpty(vehicleName) ? vehicleName : "-";
					 contractOverview.setVehicleName(vehicleName);
				 }
				 contractOverviewList.add(contractOverview);
			 }
		 }
		 return contractOverviewList;
	}

	@Override
	public void deleteById(Long contractNumber) {
		if (contractValidations.hasARecordWithOid(contractNumber))
			contractRepository.deleteById(contractNumber);
	}

	@Override
	public void deleteAll() {
		contractRepository.deleteAll();
	}
	
	@Override
	public ContractDetailsFormDTO getDropdownDetails() {
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		List<Customer> customerList = customerRepository.findAll();
		List<DropdownDTO> vehicleDropdownList = getVehicleDropdownList(vehicleList);
		List<DropdownDTO> customerDropdownList = getCustomerDropdownList(customerList);
		ContractDetailsFormDTO contractDetailsForm = new ContractDetailsFormDTO(customerDropdownList, vehicleDropdownList);
		return contractDetailsForm;
	}

	public List<DropdownDTO> getVehicleDropdownList(List<Vehicle> vehicleList) {
		List<DropdownDTO> vehicleDropdownList = new ArrayList<DropdownDTO>();
		if (!vehicleList.isEmpty()) {
			for (Vehicle vehicle : vehicleList) {
				String dropdownLabel = vehicle.getBrand()
						+ (isNotEmpty(vehicle.getModel()) ? (" " + vehicle.getModel()) : "")
						+ (vehicle.getYear() != null ? " (" + vehicle.getYear() + ")" : "") + " VIN: "
						+ vehicle.getVin();
				DropdownDTO vehicleDropdDown = new DropdownDTO(vehicle.getVin(), dropdownLabel, vehicle);
				vehicleDropdownList.add(vehicleDropdDown);
			}
		}
		return vehicleDropdownList;
	}

	public List<DropdownDTO> getCustomerDropdownList(List<Customer> customerList) {
		List<DropdownDTO> customerDropdownList = new ArrayList<DropdownDTO>();
		if(!customerList.isEmpty()) {
			for (Customer customer : customerList) {
				String customerLabel = customer.getFirstName()
						+ (isNotEmpty(customer.getLastName()) ? (" " + customer.getLastName()) : "");
				DropdownDTO customerDropdown = new DropdownDTO(customer.getId(), customerLabel, customer);
				customerDropdownList.add(customerDropdown);
			}
		}
		return customerDropdownList;
	}

	@Transactional
	@Override
	public void unMapCustomerFromContract(Long contractNumber) {
		contractRepository.unMapCustomerFromContract(contractNumber);		
	}

	@Transactional
	@Override
	public void unMapVehicleFromContract(Long contractNumber) {
		contractRepository.unMapVehicleFromContract(contractNumber);		
	}
	
	public boolean isNotEmpty(String str) {
		return str != null && str.trim() != "";
	}

	@Override
	public Contract updateContract(Long id, Contract contract) throws Exception {
		if(contractValidations.hasARecordWithOid(id) && contractValidations.isValidMonthlyRate(contract)) {
			return contractRepository.save(contract);
		}
		return null;
	}
}
