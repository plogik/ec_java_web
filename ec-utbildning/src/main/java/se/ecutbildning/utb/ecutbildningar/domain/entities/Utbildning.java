package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Utbildning {
    private String id;
    private List<Adress> adresser;
    private List<Kurs> kurser;
    private LocalDate startdatum;
    private LocalDate slutdatum;
    private String beskrivning;
    private List<Inskrivning> inskrivningar;

    @Id
    public String getId() {
        return id;
    }

    public Utbildning setId(String id) {
        this.id = id;
        return this;
    }

    @ManyToMany
    public List<Adress> getAdresser() {
        return adresser;
    }

    public Utbildning setAdresser(List<Adress> adresser) {
        this.adresser = adresser;
        return this;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    public List<Kurs> getKurser() {
        return kurser;
    }

    public Utbildning setKurser(List<Kurs> kurser) {
        this.kurser = kurser;
        return this;
    }

    public LocalDate getStartdatum() {
        return startdatum;
    }

    public Utbildning setStartdatum(LocalDate startdatum) {
        this.startdatum = startdatum;
        return this;
    }

    public LocalDate getSlutdatum() {
        return slutdatum;
    }

    public Utbildning setSlutdatum(LocalDate slutdatum) {
        this.slutdatum = slutdatum;
        return this;
    }

    @Column(length = 2048)
    public String getBeskrivning() {
        return beskrivning;
    }

    public Utbildning setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
        return this;
    }

    @OneToMany(mappedBy = "utbildning")
    @Column(name = "UTBILDNING_ID")
    public List<Inskrivning> getInskrivningar() {
        return inskrivningar;
    }

    public Utbildning setInskrivningar(List<Inskrivning> inskrivningar) {
        this.inskrivningar = inskrivningar;
        return this;
    }
}
