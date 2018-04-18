package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Utbildning {
    @Id
    private String id;

    @ManyToMany
    private List<Adress> adresser;

    @OneToMany(mappedBy = "utbildning")
    private List<Kurs> kurser;

    private Date startdatum;
    private Date slutdatum;

    @Column(length = 2048)
    private String beskrivning;
}
