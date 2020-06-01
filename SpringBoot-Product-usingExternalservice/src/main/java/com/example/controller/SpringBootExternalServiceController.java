package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.api.Product;
import com.example.exceptionhandling.ServiceException;
import com.example.service.SpringBootExternalService;

@Controller
@RequestMapping("/myapp")
public class SpringBootExternalServiceController {
	@Autowired
	SpringBootExternalService externalService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		List<Product> list = externalService.getAllProducts();
		model.addAttribute("list", list);
		return "viewProduct";
	}

	// fetch the product by id
	@RequestMapping(value = "/products/{pId}")
	public Product getProductById(@PathVariable int pId) {
		return externalService.getProductById(pId);
	}

	/* It displays a page where we can add the products */

	@RequestMapping("/addProduct")
	public String addProduct(@ModelAttribute("userReg") Product product) {
		return "addproduct";
	}

	/* It adds the products into the database */
	@RequestMapping("/result")
	public String processUserRegistration(@ModelAttribute("userReg") Product product) throws ServiceException {

		if (product.getpName() == null || product.getpName().isEmpty()) {
			throw new ServiceException("Product Name should not be empty or null", HttpStatus.BAD_REQUEST.value());
		}

		else {
			externalService.addProduct(product);

			return "result";
		}
	}

	@RequestMapping(value = "/editProduct/{pId}")
	public String edit(@PathVariable int pId, Model model) {
		Product product = externalService.getProductById(pId);
		model.addAttribute("command", product);
		return "editProduct";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public String updateProduct(@ModelAttribute("product") Product product) {
		externalService.updateProduct(product);
		return "redirect:/myapp/viewproduct";
	}

	/* It deletes record for the selected id and redirects to /viewProducts-page */
	@RequestMapping(value = "/deleteProduct/{pId}", method = RequestMethod.GET)
	public String delete(@PathVariable int pId) {
		externalService.deleteProduct(pId);
		return "redirect:/myapp/viewprodyct";	

	}
	@RequestMapping("/viewWithoutEdit")
	public String viewWithoutEdit(Model model) {
		List<Product> list = externalService.getAllProducts();
		model.addAttribute("list", list);
		return "viewWithoutEdit";

	}

}
