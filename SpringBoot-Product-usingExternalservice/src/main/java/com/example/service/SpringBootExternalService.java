package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.api.Product;

@Service
@ConfigurationProperties(prefix = "endpoint")
public class SpringBootExternalService {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Autowired
	private RestTemplate restTemplate;

	// get all the products
	public List<Product> getAllProducts() {
		ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);
		return Arrays.asList(response.getBody());

	}

	// get by Id
	public Product getProductById(int pId) {
		ResponseEntity<Product> response = restTemplate.getForEntity(url + "/" + pId, Product.class);
		return response.getBody();
	}

	// add product
	public HttpStatus addProduct(Product product) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(url, product, HttpStatus.class);
		return response.getBody();
	}

	// update product
	public void updateProduct(Product product) {
		restTemplate.put(url, product);
	}

	// deletes product
	public void deleteProduct(int pId) {
		restTemplate.delete(url + pId);

	}
}
