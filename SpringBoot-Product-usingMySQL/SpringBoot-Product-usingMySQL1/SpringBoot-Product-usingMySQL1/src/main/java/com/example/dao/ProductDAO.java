package com.example.dao;

import java.util.List;

import com.example.api.Product;

public interface ProductDAO {
	List<Product> getAllProducts();

	Product getProductById(int pId);

	void addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int pId);

	boolean productExists(String getpName, String price);

}
