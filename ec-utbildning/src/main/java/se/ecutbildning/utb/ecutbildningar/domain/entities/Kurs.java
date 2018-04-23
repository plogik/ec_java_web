package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Kurs {
    private String kurskod;
    private Date startdatum;
    private Date slutdatum;
    private List<Personal> personal;
    private Personal huvudansvarig;

    @Id
    public String getKurskod() {
        return kurskod;
    }

    public Kurs setKurskod(String kurskod) {
        this.kurskod = kurskod;
        return this;
    }

    public Date getStartdatum() {
        return startdatum;
    }

    public Kurs setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
        return this;
    }

    public Date getSlutdatum() {
        return slutdatum;
    }

    public Kurs setSlutdatum(Date slutdatum) {
        this.slutdatum = slutdatum;
        return this;
    }

    @ManyToMany
    public List<Personal> getPersonal() {
        return personal;
    }

    public Kurs setPersonal(List<Personal> personal) {
        this.personal = personal;
        return this;
    }

    @OneToOne
    public Personal getHuvudansvarig() {
        return huvudansvarig;
    }

    public Kurs setHuvudansvarig(Personal huvudansvarig) {
        this.huvudansvarig = huvudansvarig;
        return this;
    }
}
