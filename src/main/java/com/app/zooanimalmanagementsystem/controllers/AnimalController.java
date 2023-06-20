package com.app.zooanimalmanagementsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {


    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
