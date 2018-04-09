package com.example.securitydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {
    @GetMapping("hello")
    public String getHome() {
        return "hello/hello";
    }
}
