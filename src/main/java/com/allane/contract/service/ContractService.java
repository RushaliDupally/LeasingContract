package com.allane.contract.service;

import java.util.List;

import com.allane.contract.dto.ContractDetailsFormDTO;
import com.allane.contract.dto.ContractOverviewDTO;
import com.allane.contract.entity.Contract;

public interface ContractService {

	Contract saveContract(Contract contract) throws Exception;
	
	Contract getContractById(Long id);
	
	List<ContractOverviewDTO> getAllContracts();
	
	void deleteById(Long contractNumber);
	
	void deleteAll();
	
	ContractDetailsFormDTO getDropdownDetails() throws Exception;
	
	void unMapCustomerFromContract(Long contractNumber);
	
	void unMapVehicleFromContract(Long contractNumber);
	
	Contract updateContract(Long id, Contract contract) throws Exception;
}
