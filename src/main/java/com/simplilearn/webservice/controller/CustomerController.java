package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Customer;

@RestController
public class CustomerController {
	
	List<Customer> customers = new ArrayList<Customer>();
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> showCustomers() {
		if(customers.isEmpty()) {
			addCustomer();
		}
		return customers;
		}

	@RequestMapping(value="/customer", method = RequestMethod.GET)
	public Customer getCustomer(@RequestParam("id") int id) {
		for(Customer customer: customers) {
			if(customer.getId()==id) {
				return customer;
			}
		}
		return null;
		
	}
	
	@RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
	public Customer getcustomer(@PathVariable("id") int id) {
		for(Customer customer : customers) {
			if(customer.getId()==id) {
				return customer;
			}
		}
		return null;
		
	}
	
	@RequestMapping(value="/customers/search",method = RequestMethod.GET)
	public Customer searchCustomer(@RequestParam("name") String name) {
		for(Customer customer : customers) {
			if(customer.getName().contains(name)){
				return customer;
			}
		}
		return null;
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.POST)
	public List<Customer> addCustomer(@RequestBody Customer customer){
		customers.add(customer);
		return customers;
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.PUT)
	public Customer updateCustome(@RequestBody Customer customer) {
		for (int index = 0; index < customers.size(); index++) {
			if(customers.get(index).getId()==customer.getId()) {
				customers.set(index, customer);
				return customer;
			}
			
		}
		return null;
	}
	
	@RequestMapping(value="/customers/{id}", method = RequestMethod.DELETE)
	public Customer deleteCustomer(@PathVariable("id") int id) {
		for (int index = 0; index < customers.size(); index++) {
			if(customers.get(index).getId()==id) {
				Customer remove = customers.get(index);
				customers.remove(remove);
				return remove;
			}
			
		}
		return null;
	}
	private void addCustomer() {
		customers.add(new Customer(1, "John", "john@email.com", 1233123, "15,Mumbai,India"));
		customers.add(new Customer(2, "David", "david@email.com", 1254123, "23,Bangalore,India"));
		customers.add(new Customer(3, "Krish", "krish@email.com", 6733123, "45,Chennai,India"));
		customers.add(new Customer(4, "Hemachandiran", "hema@email.com", 3233123, "43,Delhi,India"));
		customers.add(new Customer(5, "Kumar", "kumar@email.com", 8933123, "25,Pune,India"));
		
	}
	}


