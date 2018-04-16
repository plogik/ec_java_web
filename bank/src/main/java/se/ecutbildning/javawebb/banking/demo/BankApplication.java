package se.ecutbildning.javawebb.banking.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Account;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Company;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);


		// Demo, builder pattern. Har inget med
        // lösningen i övrigt att göra. Magin ligger
        // i att alla set:ers returnerar this.
		Company company = new Company()
                .setName("ASEA")
				.setOrgnr("554444-1111");

		// Istället för detta
		Company company1 = new Company();
		company1.setName("ASEA");
        company1.setOrgnr("554444-1111");
	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository) {
		return args -> {
            Customer c = new Customer()
                    .setPersonnr("123")
                    .setFname("Kalle")
                    .setLname("Andreasson");
            c.setAccounts(new ArrayList<Account>() {{
                add(new Account()
                        .setName("Lönekonto")
                        .setBalance(new BigDecimal(100))
                        .setCustomer(c));
                add(new Account()
                        .setName("Sparkonto")
                        .setBalance(new BigDecimal(200))
                        .setCustomer(c));
            }});
            customerRepository.save(c);
        };
	}
}
