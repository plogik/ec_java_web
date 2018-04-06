package com.example.databasedemo.domain.repositories;

import com.example.databasedemo.domain.entities.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetRepository extends PagingAndSortingRepository<Pet, Long> {
}
