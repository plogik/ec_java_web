package se.ecutbildning.utb.ecutbildningar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home/home";
    }

    @GetMapping({"/test/{korv}", "/test"})
    public String test(@PathVariable(required = false) Optional<String> korv) {
        return "home/test";
    }
}
