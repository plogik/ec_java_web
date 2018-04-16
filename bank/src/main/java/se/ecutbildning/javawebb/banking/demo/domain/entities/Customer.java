package se.ecutbildning.javawebb.banking.demo.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {
    private String personnr;
    private String fname;
    private String lname;
    private String street;
    private String zip;
    private String city;
    private String phone;
    private String email;
    private List<Account> accounts;

    public Customer() {
    }

    @Id
    public String getPersonnr() {
        return personnr;
    }

    public Customer setPersonnr(String personnr) {
        this.personnr = personnr;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public Customer setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public Customer setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return customer.getPersonnr().equals(getPersonnr());
    }

    @Override
    public int hashCode() {
        int result = personnr.hashCode();
        return result;
    }
}
