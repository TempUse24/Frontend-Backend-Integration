package com.iiht.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.rest.model.Product;
import com.iiht.rest.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> fetchAll(){
		return productRepository.findAll();
	}
	public Product save(Product product) {
		return productRepository.findById(product.getProductId()).isPresent() ? null : productRepository.save(product);
	}
	
	public Product update(Product product) {
		return productRepository.findById(product.getProductId()).isPresent() ? productRepository.save(product) : null;
	}
	
	public Optional<Product> delete(long productId) {
		Optional<Product> deleted = productRepository.findById(productId);
		productRepository.deleteById(productId);
		return deleted;
	}
	
	public List<Product> deleteAll() {
		productRepository.deleteAll();
		return productRepository.findAll();
	}
	
	public Optional<Product> fetch(long productId) {
		Optional<Product> op  = productRepository.findById(productId);
		return op;
	}
}
