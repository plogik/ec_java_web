package se.ecutbildning.utb.ecutbildningar.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Adress;

public interface AdressRepository extends CrudRepository<Adress, Long> {
}
