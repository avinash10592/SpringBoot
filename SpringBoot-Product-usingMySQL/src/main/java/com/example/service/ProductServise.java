package com.example.service;

import java.util.List;

import com.example.api.Product;

public interface ProductServise {
	List<Product> getAllProducts();

	Product getProductById(int pId);

	boolean addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int pId);
}
