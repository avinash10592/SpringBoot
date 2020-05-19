package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Product;
import com.example.service.SpringBootExternalService;

@RestController
@RequestMapping("/myapp")
public class SpringBootExternalServiceController {
	@Autowired
	SpringBootExternalService externalService;

	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return externalService.getAllProducts();
	}

	// fetch the product by id
	@RequestMapping(value = "/products/{id}")
	public Product getProductById(@PathVariable int id) {
		return externalService.getProductById(id);
	}

	// add a product
	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody Product product) {
		externalService.addProduct(product);
	}

	// update the product
	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable int id) {
		externalService.updateProduct(product);
	}
	//deletes the product
		@RequestMapping(method= RequestMethod.DELETE, value="/products/{id}")
		public void deleteProduct(@PathVariable String id) {
			
			externalService.deleteProduct(id);
			 
		}
}
