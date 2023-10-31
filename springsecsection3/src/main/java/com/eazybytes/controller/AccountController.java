package com.eazybytes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccountController {
	
	@GetMapping("/myAccount")
	public ResponseEntity<User> getAccountDetails() {
		ResponseEntity<User> response = new RestTemplate().getForEntity("http://localhost:9999/welcome",User.class);
		return response;
	}

}
