package com.iiht.securityJWT.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.securityJWT.MyUserDetailsService;
import com.iiht.securityJWT.model.AuthenticationRequest;
import com.iiht.securityJWT.model.AuthenticationResponse;
import com.iiht.securityJWT.util.JwtUtil;


@CrossOrigin("http://localhost:4200")
@RestController
public class EmployeeResource {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	JwtUtil jwtutil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {

			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtutil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}

	@GetMapping
	@RequestMapping("/greet")
	public String greet() {
		return "working";
	}

	@GetMapping
	@RequestMapping("/admin")
	public String greetAdmin() {
		return "Admin@Work";
	}

	@GetMapping
	@RequestMapping("/user")
	public String greetUser() {
		return "User@Work";
	}
}
