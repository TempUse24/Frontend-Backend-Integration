package com.iiht.resilience._j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/rest/client")
public class HelloClientResource {
	
	@Autowired
	RestTemplate template;
	
	public final static String CLIENT_SERVICE="clientService";
	
	@GetMapping
	@CircuitBreaker(name=CLIENT_SERVICE, fallbackMethod="callOnFail")
	public String callServer() {
		
		String url="http://localhost:8094/rest/service/default";
		String output=template.getForObject(url, String.class);
		return output;
	}
	public String callOnFail(Exception e) {
		return " Call On Fail method called....";
	}
}
