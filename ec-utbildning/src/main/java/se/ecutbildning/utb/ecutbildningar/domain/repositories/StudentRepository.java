package se.ecutbildning.utb.ecutbildningar.domain.repositories;


import org.springframework.data.repository.CrudRepository;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Student;

public interface StudentRepository extends CrudRepository<Student, String> {
}
