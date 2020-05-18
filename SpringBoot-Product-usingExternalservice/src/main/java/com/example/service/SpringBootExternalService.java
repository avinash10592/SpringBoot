package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SpringBootExternalService {
	@Autowired
	private RestTemplate restTemplate;

	public List<Object> getProducts() {

		String url = "http://localhost:8081/products";
		Object[] objects = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(objects);

	}

	public void addProduct(Object object) {
		
		String url = "http://localhost:8081/products";
		Object[] objects = restTemplate.getForObject(url, Object[].class);

		 Arrays.asList(objects);
		
	}
}
