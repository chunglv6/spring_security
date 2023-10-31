package com.eazybytes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public ResponseEntity<User> sayWelcome() {
        return ResponseEntity.ok(new User("a","a@email.com",20));
    }

    @PostMapping("/welcome")
    public String sayWelcomeP() {
        return "POST Welcome from Spring Application with Security";
    }

}
