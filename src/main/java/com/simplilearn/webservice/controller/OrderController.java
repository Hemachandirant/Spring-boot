package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Order;
import com.simplilearn.webservice.exception.InvalidOrderException;
import com.simplilearn.webservice.exception.OrderNotFound;
import com.simplilearn.webservice.exception.ProductNotFound;

@RestController
public class OrderController {
	
	List<Order> orders = new ArrayList<Order>();
	
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public List<Order> getOrder(){
		if(orders.isEmpty()) {
			addOrder();
		}
		return orders;
	}
	
	@RequestMapping(value="/order/{id}", method = RequestMethod.GET)
	public Order getOrders(@PathVariable("id") int id) {
		for(Order order:orders) {
			if(order.getId()==id) {
				return order;
			}
			
		}
		throw new OrderNotFound("Order is not found with given ID"+id);
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
	
	@RequestMapping(value = "/searchOrder", method = RequestMethod.GET)
	public Order searchProduct(@RequestParam("label") String label) {
		for(Order order:orders) {
			if(order.getLabel().contains(label)) {
				return order;
			}
		}
		throw new OrderNotFound("order not found with given text"+label);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public List<Order> addOrders(@RequestBody Order order){
		if(order.getId()!=0 && order.getLabel()!=null) {
			orders.add(order);
			return orders;
		}else {
			throw new InvalidOrderException("Order cannot be added ! Required fields are missing");
		}
		
	}
	
	@RequestMapping(value="/orders", method = RequestMethod.PUT)
	public Order updateOrder(@RequestBody Order order) {
		for (int index = 0; index < orders.size(); index++) {
			if(orders.get(index).getId()==order.getId()) {
				orders.set(index, order);
				return order;
			}
			
		}
		throw new OrderNotFound("order cannnot be updated"+order.getId());
	}
	
	@RequestMapping(value="/orders/{id}", method = RequestMethod.DELETE)
	public Order deleteOrder(@PathVariable("id") int id){
		for(int index = 0;index<orders.size();index++) {
			if(orders.get(index).getId()==id) {
				Order remove = orders.get(index);
				orders.remove(remove);
				return remove;
			}
		}
		throw new OrderNotFound("order cannnot be Deleted"+id);
		
	}
	

	private void addOrder() {
		orders.add(new Order(1,"Apple","Mumbai",912312312,"apple@gmail.com","It is a tasty food"));
		orders.add(new Order(2,"Biscuts","Bangalore",943112312,"biscuts@gmail.com","It is a very crispy food"));
		orders.add(new Order(3,"Notebooks","Chennai",892312312,"notebooks@gmail.com","Very easy to write Notes"));
		orders.add(new Order(4,"Vegetables","Pune",554312312,"vegetables@gmail.com","It is a Healthy food"));
		orders.add(new Order(5,"Shampoos","Mumbai",321312312,"shampoos@gmail.com","It is used to clean Hair "));
		
	}
	
	
	

}

