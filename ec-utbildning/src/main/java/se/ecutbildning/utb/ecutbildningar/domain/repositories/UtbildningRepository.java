package se.ecutbildning.utb.ecutbildningar.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Utbildning;

public interface UtbildningRepository extends CrudRepository<Utbildning, String> {
}
