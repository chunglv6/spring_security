package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {


    public ResponseEntity<?> check() {
        return new RestTemplate().getForEntity("https://srs-ds-int1.e.corpintra.net/STARCDS/internalservices/InternalInterface", String.class);
    }
}
