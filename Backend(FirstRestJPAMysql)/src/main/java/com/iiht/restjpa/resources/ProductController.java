package com.iiht.restjpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.restjpa.entity.Product;
import com.iiht.restjpa.services.ProductService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/product/api.1.0")
public class ProductController {

	@Autowired
	 ProductService service;
	
	@GetMapping("/fetchall")
	public ResponseEntity<List<Product>> fetchAllProducts(){
		
		 return ResponseEntity.status(HttpStatus.OK).body(service.fetchAll());
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<Product> fetch(@PathVariable long id){
		
		     return  ResponseEntity.ok(service.fetch(id));
		 
	}
	
	 // http://localhost:8090//product/api.1.0/create
	
	@PostMapping(path="/create" ,
	      consumes=MediaType.APPLICATION_JSON_VALUE,
	     produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Product> createProduct(@RequestBody Product productReq){
		
		 Product newProduct = service.save(productReq);
		 return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
		
	
	}
	
	
}
