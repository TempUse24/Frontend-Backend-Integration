package com.iiht.restJPA.MYSQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.restJPA.MYSQL.entity.Product;
import com.iiht.restJPA.MYSQL.services.ProductService;

@RestController
@RequestMapping("/product/api.1.0")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping
	@RequestMapping(path="/create",
					consumes=MediaType.APPLICATION_JSON_VALUE, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product productReq){
		
		Product newProduct=service.save(productReq);
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping(path="/get")
	public ResponseEntity<List<Product>> getProduct(){
		
		List<Product> getProduct=service.fetch();
		return new ResponseEntity<List<Product>>(getProduct,HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(path="/getbyid/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		
		return ResponseEntity.ok(service.fetchById(id));
	}
	
	@PutMapping
	@RequestMapping(path="/setbyid/{id}")
	public ResponseEntity<Product> setProductById(@PathVariable Long id, @RequestBody Product product){
		
		Product updateProduct=service.update(id, product);
		if(updateProduct==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(updateProduct);
	}
	
	@DeleteMapping
	@RequestMapping(path="/deletebyid/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long id){
		
		String message=service.delete(id);
		if(message==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok().body(message);
	}

}
