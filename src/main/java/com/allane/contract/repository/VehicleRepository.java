package com.allane.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allane.contract.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
