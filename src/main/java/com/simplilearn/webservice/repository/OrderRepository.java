package com.simplilearn.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simplilearn.webservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	List<Order> findById(int id);
	List<Order> findByLabel(String label);


}
