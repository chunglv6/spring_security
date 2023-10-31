package com.example.demo.controller;

import com.example.demo.repository.*;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.bson.Document;
import org.bson.Document;

import javax.xml.bind.JAXBException;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private ContextRepository contextRepository;

    @Autowired
    private FinOrVinRepository finOrVinRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private TestService testService;

    @GetMapping("/ws/2")
    public Object getUser(){


//        throw new RetailAdapterException(new JAXBException("hahahahahaha"));
//        return ResponseEntity.status(200).header("Content-Type", "application/soap+xml").body("hahahahhahahahha") ;
        return ResponseEntity.ok("no headers");
    }
    @GetMapping("/ws/1")
    public Object getUser1(){


//        throw new RetailAdapterException(new JAXBException("hahahahahaha"));
        return ResponseEntity.status(200).header("Content-Type", "application/soap+xml").body("hahahahhahahahha") ;

    }

}
