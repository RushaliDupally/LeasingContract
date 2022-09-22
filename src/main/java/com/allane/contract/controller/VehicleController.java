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
import com.allane.contract.entity.Contract;
import com.allane.contract.entity.Vehicle;
import com.allane.contract.service.VehicleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	public VehicleService vehicleService;

	@GetMapping("/getAll")
	@ApiOperation(value = "get Vehicle List",
	notes = "Provides Vehicle Data List. Request Method: GET",
	response = Vehicle.class)
	public ResponseEntity<Response> getVehicleList() {
		String transactionId = UUID.randomUUID().toString();
		List<Vehicle> vehicleList = vehicleService.getAllVehiclesList();
		Response response = new Response(vehicleList, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{vin}")
	@ApiOperation(value ="Get Vehicle Data by ID",
	notes = "Provides Vehicle data based on Vehicle Identification Number. Request Method: GET",
	response = Vehicle.class)
	public ResponseEntity<Response> getVehicleByVin(@PathVariable("vin") Long vin) {
		String transactionId = UUID.randomUUID().toString();
		Vehicle vehicle = vehicleService.getVehicleById(vin);
		Response response = new Response(vehicle, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping("/save")
	@ApiOperation(value = "Save the Vehicle Data",
	notes = "Provide Vehicle Payload to save the data. Request Method: POST",
	response = Vehicle.class)
	public ResponseEntity<Response> saveVehicleData(@RequestBody Vehicle vehicle) {
		String transactionId = UUID.randomUUID().toString();
		Vehicle newVehicle = vehicleService.saveVehicle(vehicle);
		Response response = new Response(newVehicle, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete the Vehicle Data",
	notes = "Delete the Vehicle data based on id. Request Method: DELETE",
	response = ResponseEntity.class)
	public ResponseEntity deleteById(@PathVariable Long id) {
		vehicleService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteAll")
	@ApiOperation(value = "Delete the whole Vehicle data. Request Method: DELETE",
	notes = "Delete the whole vehicle data",
	response = ResponseEntity.class)
	public ResponseEntity deleteAll() {
		vehicleService.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Update Vehicle data",
	notes = "Update the Vehicle data based on vehicle Identification Number. Request Method: PUT",
	response = Vehicle.class)
	public ResponseEntity<Response> updateVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) throws Exception{
		String transactionId = UUID.randomUUID().toString();
		Vehicle newVehicle = vehicleService.updateVehicle(id, vehicle);
		Response response = new Response(newVehicle, LocalDateTime.now(), transactionId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	} 

}
