package com.iiht.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/service2")
public class Service2Controller {
	
	@GetMapping
	public String connect() {
		return "connected... service 2 responding";
	}
	
	@GetMapping("/{num}")
	public String evenOdd(@PathVariable int num) {
		
		if(num%2==0)
			return "Number is even";
	return "Number is Odd";
	}
	
	@GetMapping("/{num1}/{num2}")
	public String Factorial(@PathVariable int num1, @PathVariable int num2) {
		
		if(num1>num2)
			return "Number "+num1+" is greater";
	return "Number "+num2+" is bigger";
	}
	

}
