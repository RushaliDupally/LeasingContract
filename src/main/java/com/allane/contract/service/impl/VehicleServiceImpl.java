package com.allane.contract.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allane.contract.entity.Vehicle;
import com.allane.contract.repository.VehicleRepository;
import com.allane.contract.service.VehicleService;
import com.allane.contract.validations.VehicleValidations;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	public VehicleRepository vehicleRepository;
	
	@Autowired
	public VehicleValidations vehicleValidations;

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		// handle validations
		if(vehicleValidations.handleVehicleValidations(vehicle)) {
			return vehicleRepository.save(vehicle);			
		}
		return null;
	}

	@Override
	public List<Vehicle> getAllVehiclesList() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle getVehicleById(Long vin) {
		Optional<Vehicle> optVehicle = vehicleRepository.findById(vin);
		if (optVehicle.isPresent()) {
			return optVehicle.get();
		}
		return null;
	}

	@Override
	public void deleteById(Long id) {
		if(!vehicleValidations.isVehicleAssignedToAContract(id) && vehicleValidations.hasARecordWithOid(id)) {
			vehicleRepository.deleteById(id);			
		}
	}

	@Override
	public void deleteAll() {
		// delete only if none on the vehicles are being assigned to contract
		if(vehicleValidations.isValidToBeDeleted()) {
			vehicleRepository.deleteAll();			
		}
	}

	@Override
	public Vehicle updateVehicle(Long vin, Vehicle vehicle) throws Exception {
		if(vehicleValidations.hasARecordWithOid(vin) && vehicleValidations.handleVehicleValidations(vehicle)) {
			return vehicleRepository.save(vehicle);
		}
		return null;
	}

}
