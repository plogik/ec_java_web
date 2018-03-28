package se.ecutbildning.javawebb.banking.demo.domain.entities;

public class Company {
    private String orgnr;
    private String name;

    public String getOrgnr() {
        return orgnr;
    }

    public Company setOrgnr(String orgnr) {
        this.orgnr = orgnr;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }
}
