package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Product;
import com.example.service.ProductServiceImp;


@RestController
public class ProductController {

	@Autowired
	private ProductServiceImp productService;

	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();

	}

	@RequestMapping("/products/{pId}")
	public Product getProduct(@PathVariable int pId) {
		return productService.getProductById(pId);

	}
	@RequestMapping(method=RequestMethod.POST,value="/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/products/{pId}")
	public void updateProduct(@RequestBody Product product,@PathVariable int pId) {
		productService.updateProduct(product);;
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{pId}")
	public void deleteProduct(@PathVariable int pId) {
		 productService.deleteProduct(pId);;

	}

}





















































//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.example.api.Product;
//import com.example.service.ProductServiceImp;
//
//@Controller
//@RequestMapping("user")
//public class ProductController {
//
//	@Autowired
//	private ProductServiceImp productService;
//
//	@GetMapping("product/{id}")
//	public ResponseEntity<Product> getArticleById(@PathVariable("id") Integer id) {
//		Product product = productService.getProductById(id);
//		return new ResponseEntity<Product>(product, HttpStatus.OK);
//	}
//
//	@GetMapping("product")
//	public ResponseEntity<List<Product>> getAllArticles() {
//		List<Product> list = productService.getAllProducts();
//		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
//
//	}
//
//	@PostMapping("product")
//	public ResponseEntity<Void> addProduct(@RequestBody Product product, UriComponentsBuilder builder) {
//		boolean flag = productService.addProduct(product);
//		if (flag == false) {
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/product/{id}").buildAndExpand(product.getpId()).toUri());
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}
//
//	@PutMapping("product")
//	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
//		productService.updateProduct(product);
//		return new ResponseEntity<Product>(product, HttpStatus.OK);
//	}
//
//	@DeleteMapping("product/{id}")
//	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
//		productService.deleteProduct(id);
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
//}
