package com.cts.pm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.pm.entities.Product;

@Repository
public interface ProductManagementRepository extends CrudRepository<Product, Integer> {

	List<Product> findAllByProductName(String productName);

}
