package com.example.springboot2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
    @GetMapping("/")
    public String home(){
        return "hello world144";
    }
}
