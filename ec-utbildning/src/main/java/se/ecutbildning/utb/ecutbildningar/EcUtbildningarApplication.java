package se.ecutbildning.utb.ecutbildningar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import se.ecutbildning.utb.ecutbildningar.domain.entities.*;
import se.ecutbildning.utb.ecutbildningar.domain.repositories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class EcUtbildningarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcUtbildningarApplication.class, args);
    }

    @Bean
    ModelMapper mapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            PersonalRepository personalRepository,
            UtbildningRepository utbildningRepository,
            KursRepository kursRepository,
            AdressRepository adressRepository,
            InskrivningsRepository inskrivningsRepository) {
        return args -> {
            // Skapa och spara två studenter
            Student kalle =
                    new Student()
                            .setFnamn("Kalle")
                            .setEnamn("Andreasson")
                            .setPersonnr("11111");
            studentRepository.save(kalle);

            Student stina =
                    new Student()
                            .setFnamn("Stina")
                            .setEnamn("Olsson")
                            .setPersonnr("22222");
            studentRepository.save(stina);


            // Skapa och spara två anställda
            Personal lisa =
                    new Personal()
                            .setFnamn("Lisa")
                            .setEnamn("Svensson")
                            .setPersonnr("12345")
                            .setRoll(Personal.Roll.UTBILDNINGSLEDARE);
            personalRepository.save(lisa);
            Personal sven =
                    new Personal()
                            .setFnamn("Sven")
                            .setEnamn("Svensson")
                            .setPersonnr("54321")
                            .setRoll(Personal.Roll.LARARE);
            personalRepository.save(sven);

            // Skapa adress - Malmö
            Adress malmoe = new Adress()
                    .setGatuadress("Östra Kanalgatan 5")
                    .setPostnr("211 41")
                    .setOrt("Malmö");
            adressRepository.save(malmoe);

            // Skapa adress - Helsingborg
            Adress hbg = new Adress()
                    .setGatuadress("Södergatan 78")
                    .setPostnr("252 27")
                    .setOrt("Helsingborg");
            adressRepository.save(hbg);

            // Skapa utbildningar
            Utbildning java17 = new Utbildning()
                    .setId("Java17")
                    .setStartdatum(LocalDate.of(2017, 9, 1))
                    .setSlutdatum(LocalDate.of(2019, 6, 1))
                    .setAdresser(new ArrayList<Adress>() {{ add(malmoe); add(hbg); }});
            utbildningRepository.save(java17);

            Utbildning dotnet17 = new Utbildning()
                    .setId("DotNet17")
                    .setStartdatum(LocalDate.of(2017, 9, 1))
                    .setSlutdatum(LocalDate.of(2019, 6, 1));
            utbildningRepository.save(dotnet17);

            // Koppla utbildning till adresserna
            malmoe.setUtbildningar(new ArrayList<Utbildning>() {{ add(java17); }});
            adressRepository.save(malmoe);
            hbg.setUtbildningar(new ArrayList<Utbildning>() {{ add(java17); }});
            adressRepository.save(hbg);

            // Skapa kurs + koppla personal och huvudansvarig
            Kurs webjava17 =
                    new Kurs()
                            .setKurskod("WebJava17")
                            .setHuvudansvarig(lisa)
                            .setPersonal(new ArrayList<Personal>() {{ add(sven); }} );
                            //.setUtbildning(java17);
            kursRepository.save(webjava17);

            kursRepository.save(new Kurs().setKurskod("Kurs1"));
            kursRepository.save(new Kurs().setKurskod("Kurs2"));
            kursRepository.save(new Kurs().setKurskod("Kurs3"));


            // Koppla kurs till utbildning
            java17.setKurser(new ArrayList<Kurs>() {{ add(webjava17); }});
            utbildningRepository.save(java17);

            // Koppla personal till kurs
            lisa.setKurser(new ArrayList<Kurs>() {{ add(webjava17); }});
            personalRepository.save(lisa);

            // Koppla personal till kurs
            sven.setKurser(new ArrayList<Kurs>() {{ add(webjava17); }});
            personalRepository.save(sven);

            // Skriv in kalle och stina till utbildningen
            inskrivningsRepository.save(new Inskrivning().setUtbildning(java17).setStudent(kalle));
            inskrivningsRepository.save(new Inskrivning().setUtbildning(java17).setStudent(stina));
        };
    }
}
