package com.iiht.restJPA.MYSQL.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.restJPA.MYSQL.exceptions.InvalidValueException;
import com.iiht.restJPA.MYSQL.services.ProductService;

@RestController
@RequestMapping("/product2/api.2.2")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@SuppressWarnings("unused")
	@GetMapping
	@RequestMapping("/test")
	public String message(String str) throws InvalidValueException, Exception{
		
		str="abc";
		if(str==null)
			throw new NullPointerException("Value  not provided");
	
		boolean isNumeric=str.chars().anyMatch(x-> Character.isDigit(x));
		if(isNumeric)
			throw new InvalidValueException("Expected String Found int");
		else if(str.length()<8)
			throw new Exception("String Length less than 8");
		return "hello...";
	}

}
