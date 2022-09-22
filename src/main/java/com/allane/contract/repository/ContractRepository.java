package com.allane.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.allane.contract.entity.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>{

	@Query("Select count(cn) from contract cn where vehicle_vin = ?1")
	Long getContractsOnVin(Long vin);
	
	@Query("select count(cn) from contract cn where customer_oid = ?1")
	Long getContractsOnCustomerId(Long id);
	
	@Modifying
	@Query("update contract cn set cn.customer = null where cn.contractNumber = ?1")
	void unMapCustomerFromContract(Long contractNumber);
	
	@Modifying
	@Query("update contract cn set cn.vehicle = null where cn.contractNumber = ?1")
	void unMapVehicleFromContract(Long contractNumber);
	
	@Query("Select cn from contract cn where vehicle_vin = ?1")
	Contract getContractByVin(Long vin);
	
	@Query("select cn from contract cn where customer_oid = ?1")
	Contract getContractByCustomerId(Long id);
	
	@Query("select count(cn) from contract cn where vehicle_vin is not null")
	Long getContractAndVehicleMapCount();
	
	@Query("select count(cn) from contract cn where customer_oid is not null")
	Long getContractAndCustomerMapCount();
	
}
