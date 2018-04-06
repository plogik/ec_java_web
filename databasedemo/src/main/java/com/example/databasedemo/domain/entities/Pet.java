package com.example.databasedemo.domain.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {
    private Long id;
    private String breed;
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Pet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public Pet setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }
}
