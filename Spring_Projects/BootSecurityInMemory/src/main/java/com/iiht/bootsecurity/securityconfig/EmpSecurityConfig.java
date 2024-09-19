package com.iiht.bootsecurity.securityconfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class EmpSecurityConfig {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();		
	}
	
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf(
				csrf->csrf.disable()).
				authorizeHttpRequests((authorize)->
				authorize.anyRequest().authenticated()).
				httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
			.build();
	}
	
	@Bean
	JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
		
		UserDetails userDetails=User.builder().
								username("bean").
								password(passwordEncoder().
										encode("mister")).
								roles("USER").
								build();
		UserDetails adminDetails=User.builder().
								 username("bond").
								 password(passwordEncoder().
										 encode("james")).
								 roles("ADMIN").build();
		JdbcUserDetailsManager details = new JdbcUserDetailsManager(dataSource);
		details.createUser(userDetails);
		details.createUser(adminDetails);
		return details;
		//return new InMemoryUserDetailsManager(userDetails,adminDetails);
	}
	
}
