package com.iiht.feignproductservice.service;

import java.util.List;

import com.iiht.feignproductservice.model.Product;

public interface ProductService {
	
	List<Product> findAll();
	List<Product> findByCategory(String category);
	Product findById(int id);

}
