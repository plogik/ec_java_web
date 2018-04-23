package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    private String personnr;
    private String fnamn;
    private String enamn;
    private List<Inskrivning> inskrivningar;

    @Id
    public String getPersonnr() {
        return personnr;
    }

    public Student setPersonnr(String personnr) {
        this.personnr = personnr;
        return this;
    }

    public String getFnamn() {
        return fnamn;
    }

    public Student setFnamn(String fnamn) {
        this.fnamn = fnamn;
        return this;
    }

    public String getEnamn() {
        return enamn;
    }

    public Student setEnamn(String enamn) {
        this.enamn = enamn;
        return this;
    }

    @OneToMany(mappedBy = "student")
    @Column(name = "STUDENT_PERSONNR")
    public List<Inskrivning> getInskrivningar() {
        return inskrivningar;
    }

    public Student setInskrivningar(List<Inskrivning> inskrivningar) {
        this.inskrivningar = inskrivningar;
        return this;
    }
}
