package com.iiht.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClientController {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		
		return builder.routes()
				//lb-load balancers
				.route(
						"helloservice",
						r->r.path("/test/**").
						uri("lb://LBSERVICE")
					   )
				.build();
	}


}
