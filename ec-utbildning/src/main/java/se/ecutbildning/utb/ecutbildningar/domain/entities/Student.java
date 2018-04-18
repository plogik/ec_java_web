package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Student {
    @Id
    private String personnr;

    private String fnamn;
    private String enamn;

    @ManyToMany(mappedBy = "studenter")
    private List<Kurs> kurser;
}
