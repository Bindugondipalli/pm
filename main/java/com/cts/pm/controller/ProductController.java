package com.cts.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pm.entities.Product;
import com.cts.pm.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/products")
@Api(value = "The product Controller", description = "Rest controller for product")

public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@ApiOperation(value = "Get all products",
			produces = "A list of products",
			notes = "Hit this URL to get all products details"
			)



	@RequestMapping("/all")
	List<Product> getAll() {
		return service.getProducts();
	}

	@RequestMapping("/{productId}")
	Product getById(@PathVariable Integer productId) {
		return service.getProductById(productId);
	}
	
	@ApiOperation(value = "Add a product",
			consumes = "A new product is JSON",
			notes = "Hit this URL to insert a new product's details"
			)
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}
	
	
	@ApiOperation(value = "Update a products details",
			consumes = "An existing product in JSON",
			notes = "Hit this URL to update a products details"
			)

	@RequestMapping(method = RequestMethod.PUT)
	void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
	
	

	
	@RequestMapping("/{productName")
	List<Product> getProductsByName(@PathVariable String productName){
		return service.getProductsByName(productName);
	}
	
	@ApiOperation(value = "Delete a product",
			consumes = "An existing product id",
			notes = "Hit this URL to delete a product details"
			)

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{productId}")
	void deleteProductById(@PathVariable Integer productId) {
		service.deleteProduct(productId);
	}

}
