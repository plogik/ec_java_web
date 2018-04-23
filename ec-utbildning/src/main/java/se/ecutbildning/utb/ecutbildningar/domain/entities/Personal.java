package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Personal {
    public enum Roll { LARARE, UTBILDNINGSLEDARE };

    private String personnr;
    private String fnamn;
    private String enamn;
    private Roll roll;
    private List<Kurs> kurser;

    @Id
    public String getPersonnr() {
        return personnr;
    }

    public Personal setPersonnr(String personnr) {
        this.personnr = personnr;
        return this;
    }

    public String getFnamn() {
        return fnamn;
    }

    public Personal setFnamn(String fnamn) {
        this.fnamn = fnamn;
        return this;
    }

    public String getEnamn() {
        return enamn;
    }

    public Personal setEnamn(String enamn) {
        this.enamn = enamn;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Roll getRoll() {
        return roll;
    }

    public Personal setRoll(Roll roll) {
        this.roll = roll;
        return this;
    }

    @ManyToMany(mappedBy = "personal")
    public List<Kurs> getKurser() {
        return kurser;
    }

    public Personal setKurser(List<Kurs> kurser) {
        this.kurser = kurser;
        return this;
    }
}
