package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Adress {
    private Long id;
    private String gatuadress;
    private String postnr;
    private String ort;
    private List<Utbildning> utbildningar;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Adress setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGatuadress() {
        return gatuadress;
    }

    public Adress setGatuadress(String gatuadress) {
        this.gatuadress = gatuadress;
        return this;
    }

    public String getPostnr() {
        return postnr;
    }

    public Adress setPostnr(String postnr) {
        this.postnr = postnr;
        return this;
    }

    public String getOrt() {
        return ort;
    }

    public Adress setOrt(String ort) {
        this.ort = ort;
        return this;
    }

    @ManyToMany(mappedBy = "adresser")
    public List<Utbildning> getUtbildningar() {
        return utbildningar;
    }

    public Adress setUtbildningar(List<Utbildning> utbildningar) {
        this.utbildningar = utbildningar;
        return this;
    }
}
