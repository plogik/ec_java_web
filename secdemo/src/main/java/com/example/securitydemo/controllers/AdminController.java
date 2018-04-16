package com.example.securitydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @GetMapping("manage")
    public String getManage() {
        if(1 == 1)
            throw new RuntimeException("Testar fkdslfjdj fjdkslf jdksl");
        return "admin/manage";
    }
}
