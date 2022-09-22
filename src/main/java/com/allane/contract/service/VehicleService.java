package com.allane.contract.service;

import java.util.List;

import com.allane.contract.entity.Vehicle;

public interface VehicleService {
	
	Vehicle saveVehicle(Vehicle vehicle);
	
	List<Vehicle> getAllVehiclesList();
	
	Vehicle getVehicleById(Long vin);
	
	void deleteById(Long id);
	
	void deleteAll();
	
	Vehicle updateVehicle(Long vin, Vehicle vehicle) throws Exception;

}
