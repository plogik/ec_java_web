package com.example.databasedemo.domain.repositories;

import com.example.databasedemo.domain.entities.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Den här
 * @see org.springframework.data.repository.CrudRepository
 */
public interface PetRepository extends PagingAndSortingRepository<Pet, Long> {
    /**
     *
     * @param name name of the pet you are looking for
     * @return List of pets matching criteria
     */
    List<Pet> findByNameIgnoreCase(String name);
    List<Pet> findByBreedIgnoreCase(String breed);
    List<Pet> findByNameOrBreedAllIgnoreCase(String name, String breed);
    List<Pet> findByNameAndBreed(String name, String breed);
    List<Pet> findByGender(Pet.Gender gender);

    @Query("select p from Pet p where breed=?1")
    List<Pet> findCustom(String breed);
}
