package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Product;
import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.ProductNotFound;

@RestController
public class ProductController {
	
	List<Product> products = new ArrayList<Product>();
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public List<Product> getProducts(){
		if(products.isEmpty()) {
			addDefaultData();
		}
		return products;
	}
	
	@RequestMapping(value="/product/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		for(Product product:products) {
			if(product.getId()==id) {
				return product;
			}
			
		}
		
		throw new ProductNotFound("Product not found with given id"+id);
	}
	@RequestMapping(value="/product",method = RequestMethod.GET)
	public Product getProduct(@RequestParam("name") String name) {
		for(Product product : products) {
			if(product.getName().equals(name)) {
				return product;
			}
			
		}
		throw new ProductNotFound("Product not found with given Name"+name+" ");
	}
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public Product searchProduct(@RequestParam("name") String name) {
		for(Product product : products) {
			if(product.getName().contains(name)) {
				return product;
			}
		}
		throw new ProductNotFound("product not found with given text"+name+" ");
	}
	@RequestMapping(value="/products", method = RequestMethod.POST)
	public List<Product> addProduct(@RequestBody Product product){
		if(product!=null&&product.getName()!=null) {
			products.add(product);
			return products;
		}else {
			throw new InvalidProductException("Product cannot be added ! Required fields are missing");
		}
			
	}
	
	@RequestMapping(value="/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		for (int index = 0; index < products.size(); index++) {
			if(products.get(index).getId()==product.getId()) {
				products.set(index, product);
				return product;
			}
			
		}
		throw new ProductNotFound("Product cannot be updated! Product not found with given ID"+product.getId());
	}
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") int id) {
		for (int index = 0; index < products.size(); index++) {
			if(products.get(index).getId()==id) {
				Product remove = products.get(index);
				products.remove(remove);
				return remove;
			}
			
		}
		throw new ProductNotFound("Product not found with given id, Hence Product cannot be deleted"+id);
	}
	private void addDefaultData() {
		products.add(new Product(10001, "HP 10012RED Model laptop", 8993.994, "It is a laptop", true, new Date()));
		products.add(new Product(2,"Asus vivobook 14",40443.12,"Slim laptop",true,new Date()));
		products.add(new Product(3, "Apple MAC book 9345MSLV series", 10993.994, "It is a laptop", true, new Date()));
		products.add(new Product(4, "Dell slim book 98456ERSD series", 8993.994, "It is a laptop", false, new Date()));
		products.add(new Product(5, "Lenovo slim book QURW954756 model", 12993.994, "It is a laptop", true, new Date()));
	}

}
