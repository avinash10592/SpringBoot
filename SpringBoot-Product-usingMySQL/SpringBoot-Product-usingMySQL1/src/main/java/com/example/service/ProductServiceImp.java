package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.Product;
import com.example.dao.ProductDAO;
@Service
public class ProductServiceImp implements ProductServise {
	
	@Autowired
	private ProductDAO ProductDAO;
	
	@Override
	public List<Product> getAllProducts() {
		return ProductDAO.getAllProducts();
	}

	@Override
	public Product getProductById(int pId) {
		Product obj = ProductDAO.getProductById(pId);
		return obj;
	}

	@Override
	public synchronized boolean addProduct(Product product) {
		if (ProductDAO.productExists(product.getpName(), product.getPrice())) {
	          return false;
          } else {
        	  ProductDAO.addProduct(product);
	          return true;
          }
	}

	@Override
	public void updateProduct(Product product) {
		ProductDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(int pId) {
		ProductDAO.deleteProduct(pId);

	}

}
