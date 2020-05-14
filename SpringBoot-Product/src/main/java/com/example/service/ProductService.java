package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api.Product;

@Service
public class ProductService {

	private List<Product> products = new ArrayList<>((Arrays.asList(new Product("101", "Test1", "10"),
			new Product("102", "Test2", "20"), new Product("103", "Test3", "30"))));

	public List<Product> getAllProducts() {
		return products;

	}

	public Product getProduct(String id) {
		return products.stream().filter(p -> p.getpId().equals(id)).findFirst().get();
	}

	public void addProduct(Product product) {
		products.add(product);

	}

	public void updateProduct(String id, Product product) {
		for(int loop =0;loop<products.size();loop++) {
			Product p=products.get(loop);
			if(p.getpId().equals(id)) {
				products.set(loop, product);
				return;
			}
		}
		
	}

	public void deleteProduct(String id) {
		products.removeIf(p->p.getpId().equals(id));
	}

	

}
