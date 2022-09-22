package com.allane.contract.service;

import java.util.List;

import com.allane.contract.dto.ContractDetailsFormDTO;
import com.allane.contract.entity.Customer;

public interface CustomerService {

	Customer saveCustomerData(Customer customer) throws Exception;

	Customer getCustomerById(Long id) throws Exception;

	List<Customer> getCustomerList() throws Exception;

	void deleteById(Long id) throws Exception;

	void deleteAll() throws Exception;
	
	Customer updateCustomerData(Long id, Customer customer) throws Exception;

}
