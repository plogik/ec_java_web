package se.ecutbildning.utb.ecutbildningar.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Personal;

public interface PersonalRepository extends CrudRepository<Personal, String> {
}
