package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SpringBootExternalService;

@RestController
@RequestMapping("/myapp")
public class SpringBootExternalServiceController {
	@Autowired
	SpringBootExternalService externalService;

	@GetMapping("/products")
	public List<Object> getProducts() {
		return externalService.getProducts();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody Object object) {
		externalService.addProduct(object);
		
	}
}
