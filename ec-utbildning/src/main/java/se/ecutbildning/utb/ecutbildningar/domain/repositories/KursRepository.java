package se.ecutbildning.utb.ecutbildningar.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Kurs;

public interface KursRepository extends CrudRepository<Kurs, String> {
}
