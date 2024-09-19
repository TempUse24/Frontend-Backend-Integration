package com.iiht.Store_proj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.Store_proj.entity.Bread;
import com.iiht.Store_proj.repository.BreadRepo;

@RestController
@RequestMapping("/bread/api")
public class BreadController {
	
	@Autowired
	BreadRepo repo;
	
	@PostMapping
	@RequestMapping("/create")
	public ResponseEntity<Bread> create(@RequestBody Bread choco){
		
		return new ResponseEntity<Bread>(repo.save(choco),HttpStatus.CREATED);
	}

	@GetMapping
	@RequestMapping(path="/get")
	public ResponseEntity<List<Bread>> getProduct(){
		
		List<Bread> getProduct=repo.findAll();
		return new ResponseEntity<List<Bread>>(getProduct,HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(path="/getbyid/{id}")
	public ResponseEntity<Optional<Bread>> getProductById(@PathVariable Long id){
		
		return ResponseEntity.ok(repo.findById(id));
	}
	
	@PutMapping
	@RequestMapping(path="/setbyid/{id}")
	public ResponseEntity<Bread> setProductById(@PathVariable Long id, @RequestBody Bread product){
		
		if(repo.findById(id).isPresent()) {
			Bread updateProduct=repo.save(product);
			return ResponseEntity.ok(updateProduct);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping
	@RequestMapping(path="/deletebyid/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long id){
		
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.ok("Record Deleted sucessfully");
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}


}
