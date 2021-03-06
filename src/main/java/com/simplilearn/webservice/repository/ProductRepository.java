package com.simplilearn.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.webservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	List<Product> findByPrice(double price);
	List<Product> findByIsAvailable(boolean isAvailable);
	
	@Query("select p from Product p where p.name LIKE %?1%")
	List<Product> searchByName(String name);

}
