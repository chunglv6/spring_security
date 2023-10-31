package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTestController {
    @Autowired
    private TestService testService;
    @GetMapping("/ws/test")
    public ResponseEntity<?> test() throws Exception {
        int i = 1/0;
        return testService.check();
    }
}
