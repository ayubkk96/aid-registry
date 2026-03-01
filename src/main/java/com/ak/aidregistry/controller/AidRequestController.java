package com.ak.aidregistry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AidRequestController {
    @GetMapping("/users")
    public String getUsers() {
        return "Greetings from Spring Boot!";
    }
}