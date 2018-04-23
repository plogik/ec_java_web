package se.ecutbildning.utb.ecutbildningar.presentation.formmodels;

import se.ecutbildning.utb.ecutbildningar.domain.entities.Utbildning;

import javax.validation.constraints.Size;
import java.util.List;

public class AdressForm {
    private Long id;
    private String gatuadress;
    private String postnr;
    private String ort;
    private List<Utbildning> utbildningar;

    public Long getId() {
        return id;
    }

    public AdressForm setId(Long id) {
        this.id = id;
        return this;
    }

    @Size(min = 2, max = 255)
    public String getGatuadress() {
        return gatuadress;
    }

    public AdressForm setGatuadress(String gatuadress) {
        this.gatuadress = gatuadress;
        return this;
    }

    @Size(min = 5, max = 8)
    public String getPostnr() {
        return postnr;
    }

    public AdressForm setPostnr(String postnr) {
        this.postnr = postnr;
        return this;
    }

    @Size(min = 2, max = 255)
    public String getOrt() {
        return ort;
    }

    public AdressForm setOrt(String ort) {
        this.ort = ort;
        return this;
    }

    public List<Utbildning> getUtbildningar() {
        return utbildningar;
    }

    public AdressForm setUtbildningar(List<Utbildning> utbildningar) {
        this.utbildningar = utbildningar;
        return this;
    }
}
