package com.example.databasedemo.controllers;

import com.example.databasedemo.domain.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("pet")
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @Value("${petstore.list.pagesize}")
    private int pageSize;

    @GetMapping("list")
    public String list(@RequestParam(required = false) Integer page, Model model) {
        model.addAttribute("pets",
                petRepository.findAll(
                        PageRequest.of(page != null ? page : 0, pageSize)));
        return "pet/list";
    }

    @GetMapping("byname")
    private String byname(@RequestParam(required = false) String name,
                          @RequestParam(required = false) String breed,
                          Model model) {
        model.addAttribute("pets",
                petRepository.findCustom(breed));
        return "pet/list";
    }
}
