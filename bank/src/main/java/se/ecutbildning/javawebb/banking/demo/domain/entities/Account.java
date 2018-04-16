package se.ecutbildning.javawebb.banking.demo.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Account {
    private Long accountNbr;
    private String name;
    private BigDecimal balance;
    private Customer customer;

    @Id
    @GeneratedValue
    public Long getAccountNbr() {
        return accountNbr;
    }

    public Account setAccountNbr(Long accountNbr) {
        this.accountNbr = accountNbr;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Account setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public Account setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
