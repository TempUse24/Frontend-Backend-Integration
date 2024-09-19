package com.iiht.Gateway;

//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfiguration {
	
//	@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//		
//		return builder.routes()
//				.route(
//						"helloservice",
//						r->r.path("/rest/service/**").
//						filters(f->f.addRequestHeader("Hello", "World")).
//						uri("http:/localhost:8071")
//					  ) //lb-load balancers
//				.route(
//						"helloservice2",
//						r->r.path("/rest/service2/**").
//						uri("http:/localhost:8070")
//					   )
//				.build();
//	}

}
