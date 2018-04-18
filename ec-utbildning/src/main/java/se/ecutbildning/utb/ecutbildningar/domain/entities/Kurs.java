package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Kurs {
    @Id
    private String kurskod;

    @ManyToOne
    private Utbildning utbildning;

    private Date startdatum;
    private Date slutdatum;

    @ManyToMany
    private List<Personal> personal;

    @ManyToMany
    private List<Student> studenter;

    @OneToOne
    private Personal huvudansvarig;
}
