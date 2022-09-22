package com.allane.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allane.contract.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
