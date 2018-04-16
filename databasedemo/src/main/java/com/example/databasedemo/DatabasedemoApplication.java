package com.example.databasedemo;

import com.example.databasedemo.domain.entities.Pet;
import com.example.databasedemo.domain.repositories.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DatabasedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabasedemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PetRepository petRepository) {
        return  args -> {
            List<Pet> pets = new ArrayList<Pet>();
            for(int i = 0; i < 100; i++) {
                pets.add(new Pet()
                        .setBreed("Cat")
                        .setName("Missan " + i)
                        .setGender(i % 2 == 0 ? Pet.Gender.Female : Pet.Gender.Male));
            }
            petRepository.saveAll(pets);

            petRepository.save(new Pet().setBreed("Hund").setName("Fido"));
            petRepository.save(new Pet().setBreed("Hund").setName("Isak"));
        };
    }
}
