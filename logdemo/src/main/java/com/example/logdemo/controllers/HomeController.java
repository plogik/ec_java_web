package com.example.logdemo.controllers;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private Logger logger;

    public HomeController(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("/")
    public String home() {
        logger.debug("Debug message");

        try {
            // Simulerar ett fel...
            throw new Exception("Här kommer ett fel!");
        }
        catch(Exception ex) {
            // Bör alltid logga undantag som hanteras, annars har vi ingen aning om vad som hänt
            logger.error("Something went wrong", ex);
        }

        return "index";
    }
}
