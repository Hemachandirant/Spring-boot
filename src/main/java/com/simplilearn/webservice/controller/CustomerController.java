package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Customer;
import com.simplilearn.webservice.entity.Order;
import com.simplilearn.webservice.exception.CustomerAlreadyExist;
import com.simplilearn.webservice.exception.CustomerNotFound;
import com.simplilearn.webservice.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	List<Customer> customers = new ArrayList<Customer>();
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> showCustomers() {
		List<Customer> customerdata = customerRepository.findAll();
		if(customerdata.isEmpty()) {
			throw new CustomerNotFound("Customer details not found");
			
		}
		return customerdata;
		}

	@RequestMapping(value="/customer", method = RequestMethod.GET)
	public List<Customer> getCustomer(@RequestParam("name") String name) {
		List<Customer> customerdata = customerRepository.findByName(name);
		if(!customerdata.isEmpty()) {
			return customerdata;
		}
		throw new CustomerNotFound("Customer details not found with given name "+name);
		
	}
	
	@RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
	public List<Customer> getcustomer(@PathVariable("id") int id) {
		
		List<Customer> customerdata = customerRepository.findById(id);
		if(!customerdata.isEmpty()) {
			return customerdata;
		}
		throw new CustomerNotFound("Customer details  not found with given id"+id);
		
	}
	
	@RequestMapping(value="/customers/search",method = RequestMethod.GET)
	public List<Customer> searchCustomer(@RequestParam("name") String name) {
		List<Customer> customerdata = customerRepository.findByName(name);
		if(!customerdata.isEmpty()) {
			return customerdata;
		}
		throw new CustomerNotFound("Customer details not found with given name"+name);
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer){
		List<Customer> customerdata = customerRepository.findById(customer.getId());
		if(customerdata!=null && customer.getId()!=0) {
			return customerRepository.save(customer);
		}
		throw new CustomerAlreadyExist("Customer details cannot be added");
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer) {
		List<Customer> customerdata = customerRepository.findById(customer.getId());
		if(customerdata!=null && customer.getId()!=0) {
			return customerRepository.save(customer);
		}
		throw new CustomerNotFound("Customer details cannot be updated");
	}
	
	@RequestMapping(value="/customers/{id}", method = RequestMethod.DELETE)
	public List<Customer> deleteCustomer(@PathVariable("id") int id) {
		List<Customer> customerdata = customerRepository.findById(id);
		if(!customerdata.isEmpty()) {
			customerRepository.deleteAll(customerdata);
			return customerdata;
			}
		throw new CustomerNotFound("Customer details cannot be deleted");
	}
	}


