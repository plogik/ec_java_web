package se.ecutbildning.utb.ecutbildningar.presentation.formmodels;

import se.ecutbildning.utb.ecutbildningar.domain.entities.Adress;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Kurs;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class UtbildningForm {
    private String id;
    private List<Adress> adresser;
    private List<Kurs> kurser;
    private LocalDate startdatum;
    private LocalDate slutdatum;
    private String beskrivning;

    private Iterable<Adress> allaAdresser;
    private Iterable<Kurs> allaKurser;

    public String getId() {
        return id;
    }

    public UtbildningForm setId(String id) {
        this.id = id;
        return this;
    }

    public List<Adress> getAdresser() {
        return adresser;
    }

    public UtbildningForm setAdresser(List<Adress> adresser) {
        this.adresser = adresser;
        return this;
    }

    public List<Kurs> getKurser() {
        return kurser;
    }

    public UtbildningForm setKurser(List<Kurs> kurser) {
        this.kurser = kurser;
        return this;
    }

    @NotNull
    public LocalDate getStartdatum() {
        return startdatum;
    }

    public UtbildningForm setStartdatum(LocalDate startdatum) {
        this.startdatum = startdatum;
        return this;
    }

    @NotNull
    public LocalDate getSlutdatum() {
        return slutdatum;
    }

    public UtbildningForm setSlutdatum(LocalDate slutdatum) {
        this.slutdatum = slutdatum;
        return this;
    }

    @Size(min = 10)
    public String getBeskrivning() {
        return beskrivning;
    }

    public UtbildningForm setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
        return this;
    }

    public Iterable<Adress> getAllaAdresser() {
        return allaAdresser;
    }

    public UtbildningForm setAllaAdresser(Iterable<Adress> allaAdresser) {
        this.allaAdresser = allaAdresser;
        return this;
    }

    public Iterable<Kurs> getAllaKurser() {
        return allaKurser;
    }

    public UtbildningForm setAllaKurser(Iterable<Kurs> allaKurser) {
        this.allaKurser = allaKurser;
        return this;
    }
}
