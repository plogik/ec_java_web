package se.ecutbildning.javawebb.banking.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Company;

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
}
