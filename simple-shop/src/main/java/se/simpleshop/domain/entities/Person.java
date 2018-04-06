package se.simpleshop.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.util.List;
import java.util.ArrayList;

@Entity
public class Person {
	private Long id;

	private String name;

	private List<Pet> pets;

	public Person setId(Long id) {
		this.id = id;
		return this;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public Person setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	public List<Pet> getPets() {
		return pets;
	}

	@Override
	public String toString() {
		return "Person, id:" + id + ", name:" + name;
	}
}