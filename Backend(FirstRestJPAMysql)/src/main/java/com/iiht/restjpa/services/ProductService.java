package com.iiht.restjpa.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.restjpa.entity.Product;
import com.iiht.restjpa.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository repository;
	
	public List<Product> fetchAll() {
		
              return repository.findAll();        
}
	
	public Product fetch(long productId) {
		
		             java.util.Optional<Product>  optional =  repository.findById(1234L);
		             if(optional.isPresent())
		            	 return optional.get();
		             else
		            	 return null;
	}
	
	public Product update(Product product,long productId) {
		  // one coming from front end and the other coming from db 
		// validation logic 
		   return repository.save(product);  // save, saveUpdate
	}
	
	public Product save(Product product) {
		
		   return repository.save(product);  // save, saveUpdate
	}
}
