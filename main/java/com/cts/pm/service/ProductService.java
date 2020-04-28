package com.cts.pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pm.entities.Product;
import com.cts.pm.repo.ProductManagementRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductManagementRepository repo;

	public List<Product> getProducts() {
		return (List<Product>) repo.findAll();
	}

	public Product getProductById(Integer productId) {
		return repo.findById(productId).orElseThrow(()->new RuntimeException("Item not found"));
	}

	public void addProduct(Product product) {
		repo.save(product);
	}

	public void deleteProduct(Integer productId) {
		repo.deleteById(productId);
		
	}

	public void updateProduct(Product product) {
		repo.save(product);
	}
	
	public List<Product> getProductsByName(String productName){
		return (List<Product>) repo.findAllByProductName(productName);
	}

}
