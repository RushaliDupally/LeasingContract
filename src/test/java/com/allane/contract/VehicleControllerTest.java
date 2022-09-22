package com.allane.contract;

//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.allane.contract.entity.Vehicle;
//import com.allane.contract.repository.VehicleRepository;
//import com.allane.contract.service.VehicleService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class VehicleControllerTest {
	
	/*

	@Autowired
	public VehicleService vehicleService;
	
	@MockBean
	public VehicleRepository vehicleRepository;
	
	@Test
	public void getVehicleById() {
		Long vin = 2l;
		Vehicle vehicleData = new Vehicle(vin, "BMW", "abc", 2022, 120000d);
		when(vehicleRepository.findById(vin).get()).thenReturn(vehicleData);
		assertEquals(vehicleData, vehicleService.getVehicleById(vin));		
	}
	
	@Test
	public void saveData() {
		Vehicle vehicle = new Vehicle();
		vehicle.setBrand("AUDI");
		vehicle.setModel("ABC");
		vehicle.setYear(2011);
		vehicle.setPrice(1222.333);		
		when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
		assertEquals(vehicle, vehicleService.saveVehicle(vehicle));
	}
	
	@Test
	public void deleteVehicle() {
		Long vin = 2l;
		vehicleService.deleteById(vin);
		verify(vehicleRepository, times(1)).deleteById(vin);
	}*/
}
