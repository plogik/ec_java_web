package se.ecutbildning.javawebb.banking.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Account;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Customer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DummyDatabase {
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public DummyDatabase() {
        Random rnd = new Random(System.currentTimeMillis());

        Customer c1 = new Customer();
        c1.setCustomerNo(1L);
        c1.setFname("Kalle");
        c1.setLname("Andreasson");
        c1.setCity("Malmö");
        c1.setZip("12345");
        c1.setStreet("Storgatan 1");

        Account a1 = new Account();
        a1.setAccountNbr(rnd.nextLong());
        a1.setBalance(new BigDecimal(25.5));
        a1.setName("Lönekonto");

        Account a2 = new Account();
        a2.setAccountNbr(rnd.nextLong());
        a2.setBalance(new BigDecimal(125));
        a2.setName("Företagskonto");

        c1.setAccounts(Arrays.asList(a1, a2));


        Customer c2 = new Customer();
        c2.setCustomerNo(2L);
        c2.setFname("Lisa");
        c2.setLname("Svensson");
        c2.setCity("Helsingborg");
        c2.setZip("12345");
        c2.setStreet("Storgatan 1");

        a1 = new Account();
        a1.setAccountNbr(1l);
        a1.setBalance(new BigDecimal(125.5));
        a1.setName("Lönekonto");

        a2 = new Account();
        a2.setAccountNbr(2l);
        a2.setBalance(new BigDecimal(1125));
        a2.setName("Företagskonto");

        c2.setAccounts(Arrays.asList(a1, a2));

        setCustomers(Arrays.asList(c1, c2));

    }
}
