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

import com.simplilearn.webservice.entity.Order;
import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.OrderNotFound;
import com.simplilearn.webservice.exception.ProductNotFound;
import com.simplilearn.webservice.repository.OrderRepository;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	List<Order> orders = new ArrayList<Order>();
	
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public List<Order> getOrder(){
		List<Order> orderlist = orderRepository.findAll();
		if(orderlist.isEmpty()) {
			throw new OrderNotFound("order not found!");
		}
		return orderlist;
	}
	
	@RequestMapping(value="/order/{id}", method = RequestMethod.GET)
	public List<Order> getOrders1(@PathVariable("label") String label) {
		List<Order> productdata = orderRepository.findByLabel(label);
		if(!productdata.isEmpty()) {
			return productdata;
		}
			
		throw new ProductNotFound("Product not found with given Name "+label+" ");
	}
	@RequestMapping(value="/order", method = RequestMethod.GET)
	public Order getOrders(@RequestParam("label") String label) {
		for(Order order:orders) {
			if(order.getLabel().equals(label)) {
				return order;
			}
		}
		throw new OrderNotFound("order not found with given label"+label);
	}
	
	@RequestMapping(value = "/filter/order", method = RequestMethod.GET)
	public List<Order> filterorder(@RequestParam("id") int id) {
		List<Order> orderList = orderRepository.findById(id);
		if (!orderList.isEmpty()) {
			return orderList;
		}
		throw new ProductNotFound("Product not found with avaialable status '" + id + "'");
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public Order addOrders(@RequestBody Order order){
		if(order!=null&&order.getLabel()!=null) {
			return orderRepository.save(order);
		}else {
			throw new InvalidProductException("Product cannot be added ! Required fields are missing");
		}
			
	}
	@RequestMapping(value="/orders", method = RequestMethod.PUT)
	public Order updateOrder(@RequestBody Order order) {
		List<Order> orderdata = orderRepository.findById(order.getId());
		if(!orderdata.isEmpty()) {
			return orderRepository.save(order);
			
		}
			
			throw new ProductNotFound("Product cannot be updated! Product not found with given ID"+order.getId());
	}
	
	@RequestMapping(value="/orders/{id}", method = RequestMethod.DELETE)
	public List<Order> deleteOrder(@PathVariable("id") int id){
		List<Order> orderdata = orderRepository.findById(id);
		if(!orderdata.isEmpty()) {
			orderRepository.deleteAll(orderdata);
			return orderdata;
			}
		throw new OrderNotFound("order cannnot be Deleted"+id);
		
	}
	
	
	

}

