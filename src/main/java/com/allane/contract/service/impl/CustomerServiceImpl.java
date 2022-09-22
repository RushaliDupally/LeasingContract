package com.allane.contract.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allane.contract.entity.Customer;
import com.allane.contract.repository.CustomerRepository;
import com.allane.contract.service.CustomerService;
import com.allane.contract.validations.CustomerValidations;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	public CustomerValidations customerValidations;

	@Override
	public Customer saveCustomerData(Customer customer) throws Exception {
		if(customerValidations.handleCustomerValidations(customer)) {
			return customerRepository.save(customer);			
		}
		return null;
	}

	@Override
	public Customer getCustomerById(Long id) throws Exception{
		Optional<Customer> optCust = customerRepository.findById(id);
		if(optCust.isPresent()) {
			return optCust.get();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerList() throws Exception {
		return customerRepository.findAll();
	}

	@Override
	public void deleteById(Long id) throws Exception {
		if(!customerValidations.isCustomerAssignedToAContract(id) && customerValidations.hasARecordWithOid(id)) {
			customerRepository.deleteById(id);	
		}	
	}

	@Override
	public void deleteAll() throws Exception {
		if(customerValidations.isValidToBeDeleted()) {
			customerRepository.deleteAll();			
		}
	}

	@Override
	public Customer updateCustomerData(Long id, Customer customer) throws Exception {
		if(customerValidations.hasARecordWithOid(id) && customerValidations.handleCustomerValidations(customer)) {
			return customerRepository.save(customer);			
		}
		return null;
	}

}
