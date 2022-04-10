package com.simplilearn.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByName(String name);
	List<Customer> findById(int Id);

}
