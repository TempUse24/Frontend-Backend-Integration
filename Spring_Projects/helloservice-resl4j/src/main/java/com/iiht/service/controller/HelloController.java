package com.iiht.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/service")
public class HelloController {
	
	@Autowired
	Environment environment;
	
	@GetMapping
	@RequestMapping("/default")
	public String Welcome() {
		String port=environment.getProperty("server.port");
		return "Programming Microservice @"+port;
	}
	
	@GetMapping
	public String confirm(@RequestHeader HttpHeaders header) {
		
		return "connected.... responding"+header;
	}

}
