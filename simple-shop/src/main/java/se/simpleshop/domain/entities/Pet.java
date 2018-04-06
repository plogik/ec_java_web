package se.simpleshop.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pet {
    private Long id;
    private String breed;
    private String name;
    private Person person;

    public Pet setId(Long id) {
        this.id = id;
        return this;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Pet setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pet setPerson(Person person) {
        this.person = person;
        return this;
    }

    @ManyToOne
    public Person getPerson() {
        return person;
    }
}