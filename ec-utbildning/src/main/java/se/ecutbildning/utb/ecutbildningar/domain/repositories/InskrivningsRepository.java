package se.ecutbildning.utb.ecutbildningar.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Inskrivning;

public interface InskrivningsRepository extends CrudRepository<Inskrivning, Long> {
}
