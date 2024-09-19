package com.iiht.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/client")
public class HelloClient {

	@Autowired
	RestTemplate template;

	@GetMapping
	public ResponseEntity<String> connect() {

		String url = "http://localhost:8073/rest/service";
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		return response;
	}

	
	  @GetMapping("/{num}") 
	  public ResponseEntity<String> connect(@PathVariable int num) {
	  String url="http://localhost:8073/rest/service2/"+num; 
	  ResponseEntity<String> response=template.getForEntity(url, String.class);
	  return response; 
	  }	 
	  
	  @GetMapping("/{num1}/{num2}") 
	  public ResponseEntity<String> connect2(@PathVariable int num1, @PathVariable int num2) {
	  String url="http://localhost:8073/rest/service2/"+num1+"/"+num2; 
	  ResponseEntity<String> response=template.getForEntity(url, String.class);
	  return response; 
	  }	 

}
