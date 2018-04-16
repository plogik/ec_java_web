package com.example.databasedemo.domain.entities;

import javax.persistence.*;

@Entity
public class Pet {

    public enum Gender { Female, Male }

    private Long id;
    private String breed;
    private String name;
    private Gender gender;

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

    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public Pet setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
