package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

//	private List<Product> products = new ArrayList<>((Arrays.asList(new Product("101", "Test1", "10"),
//			new Product("102", "Test2", "20"), new Product("103", "Test3", "30"))));

	public List<Product> getAllProducts() {
		// return products;
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	public Optional<Product> getProduct(String id) {
		// return products.stream().filter(p ->
		// p.getpId().equals(id)).findFirst().get();
		return productRepository.findById(id);
	}

	public void addProduct(Product product) {
		// products.add(product);
		productRepository.save(product);

	}

	public void updateProduct(String id, Product product) {
//		for (int loop = 0; loop < products.size(); loop++) {
//			Product p = products.get(loop);
//			if (p.getpId().equals(id)) {
//				products.set(loop, product);
//				return;
//			}
//		}
		productRepository.save(product);

	}

	public void deleteProduct(String id) {
		//products.removeIf(p -> p.getpId().equals(id));
		productRepository.deleteById(id);
	}

}
