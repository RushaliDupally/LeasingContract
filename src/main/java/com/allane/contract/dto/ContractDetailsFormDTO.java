package com.allane.contract.dto;

import java.util.List;

public class ContractDetailsFormDTO {
	private List<DropdownDTO> customerDropdown;
	private List<DropdownDTO> vehicleDropdown;
	
	public ContractDetailsFormDTO(List<DropdownDTO> customerDropdown, List<DropdownDTO> vehicleDropdown) {
		super();
		this.customerDropdown = customerDropdown;
		this.vehicleDropdown = vehicleDropdown;
	}
	
	public List<DropdownDTO> getCustomerDropdown() {
		return customerDropdown;
	}
	public void setCustomerDropdown(List<DropdownDTO> customerDropdown) {
		this.customerDropdown = customerDropdown;
	}
	public List<DropdownDTO> getVehicleDropdown() {
		return vehicleDropdown;
	}
	public void setVehicleDropdown(List<DropdownDTO> vehicleDropdown) {
		this.vehicleDropdown = vehicleDropdown;
	}
}
