package com.iiht.restJPA.MYSQL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.restJPA.MYSQL.entity.Product;
import com.iiht.restJPA.MYSQL.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public Product save(Product product) {
		
		return repository.save(product);
	}
	
	public List<Product> fetch(){
		
		return repository.findAll();
	}
	
	public Product fetchById(Long id) {
		
		Optional<Product> data= repository.findById(id);
		if(data.isPresent())
			return data.get();
		return null;
	}
	
	public Product update(Long id, Product product) {
		
		if(repository.findById(id).isPresent())
			return repository.save(product);
		return null;
	}
	
	public String delete(Long id) {
		if(repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return "Record Deleted Sucessfully";
		}
		return null;
		
	}

}
