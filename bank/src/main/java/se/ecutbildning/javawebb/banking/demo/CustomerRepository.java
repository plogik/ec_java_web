package se.ecutbildning.javawebb.banking.demo;

import org.springframework.data.repository.CrudRepository;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
