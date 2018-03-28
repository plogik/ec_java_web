package se.ecutbildning.javawebb.banking.demo.domain.entities;

import java.math.BigDecimal;

public class Account {
    private Long accountNbr;
    private String name;
    private BigDecimal balance;

    public Long getAccountNbr() {
        return accountNbr;
    }

    public void setAccountNbr(Long accountNbr) {
        this.accountNbr = accountNbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
