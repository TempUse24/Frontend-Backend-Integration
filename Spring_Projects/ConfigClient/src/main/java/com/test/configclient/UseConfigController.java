package com.test.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readprops")
public class UseConfigController {
	
	@Value("${server.port.key}")
	String serverPort;
	
	@Value("${spring.application.name}")
	String appName;
	
	@Value("${message}")
	String msg;
	
	@Value("${message2}")
	String msg2;
	
	@GetMapping
	public String showProps() {
		return "port = "+serverPort+", AppName "+appName+"<br> Message1= "+msg+", Message2= "+msg2;
	}
	
	@GetMapping("/messages")
	public String showProps2() {
		return "Message1= "+msg+", Message2= "+msg2;
	}

}
