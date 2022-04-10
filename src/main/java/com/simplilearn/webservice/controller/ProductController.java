package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Product;
import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.ProductNotFound;
import com.simplilearn.webservice.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	List<Product> products = new ArrayList<Product>();
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public List<Product> getProducts(){
		List<Product> productList = productRepository.findAll(); 
		if (productList.isEmpty()) {
			throw new ProductNotFound("Product not found, product list is empty");
		}
		return productList;
	}
	
	@RequestMapping(value="/product/{id}", method = RequestMethod.GET)
	public Optional<Product> getProduct(@PathVariable("id") int id) {
		Optional<Product> productdata = productRepository.findById(id);
		if(!productdata.isEmpty()) {
			return productdata;
		}
	throw new ProductNotFound("Product Not found with ID"+id) ;
		}
	@RequestMapping(value="/product",method = RequestMethod.GET)
	public List<Product> getProduct(@RequestParam("name") String name) {
		List<Product> productdata = productRepository.findByName(name);
		if(!productdata.isEmpty()) {
			return productdata;
		}
			
		throw new ProductNotFound("Product not found with given Name "+name+" ");
	}
	@RequestMapping(value = "/filter/product", method = RequestMethod.GET)
	public List<Product> filterProduct(@RequestParam("available") boolean available) {
		List<Product> productList = productRepository.findByIsAvailable(available);
		if (!productList.isEmpty()) {
			return productList;
		}
		throw new ProductNotFound("Product not found with avaialable status '" + available + "'");
	}
	@RequestMapping(value="/products", method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product){
		if(product!=null&&product.getName()!=null) {
			return productRepository.save(product);
		}else {
			throw new InvalidProductException("Product cannot be added ! Required fields are missing");
		}
			
	}
	
	@RequestMapping(value="/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		Optional<Product> productdata = productRepository.findById(product.getId());
		if(productdata.isPresent()) {
			return productRepository.save(product);
			
		}
			
			throw new ProductNotFound("Product cannot be updated! Product not found with given ID"+product.getId());
	}
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") int id) {
		Optional<Product> productdata = productRepository.findById(id);
		if(productdata.isPresent()) {
			productRepository.delete(productdata.get());
			return productdata.get();
			}
		throw new ProductNotFound("Product is not found and Hence it cannot be deleted"+id);
		}

}
