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

import com.iiht.Store_proj.entity.Eggs;
import com.iiht.Store_proj.repository.EggRepo;

@RestController
@RequestMapping("/eggs/api")
public class EggController {
	
	@Autowired
	EggRepo repo;
	
	@PostMapping
	@RequestMapping("/create")
	public ResponseEntity<Eggs> create(@RequestBody Eggs egg){
		
		return new ResponseEntity<Eggs>(repo.save(egg),HttpStatus.CREATED);
	}

	@GetMapping
	@RequestMapping(path="/get")
	public ResponseEntity<List<Eggs>> getProduct(){
		
		List<Eggs> getProduct=repo.findAll();
		return new ResponseEntity<List<Eggs>>(getProduct,HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(path="/getbyid/{id}")
	public ResponseEntity<Optional<Eggs>> getProductById(@PathVariable Long id){
		
		return ResponseEntity.ok(repo.findById(id));
	}
	
	@PutMapping
	@RequestMapping(path="/setbyid/{id}")
	public ResponseEntity<Eggs> setProductById(@PathVariable Long id, @RequestBody Eggs product){
		
		if(repo.findById(id).isPresent()) {
			Eggs updateProduct=repo.save(product);
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
