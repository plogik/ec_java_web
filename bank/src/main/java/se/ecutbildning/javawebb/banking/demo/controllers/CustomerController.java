package se.ecutbildning.javawebb.banking.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.ecutbildning.javawebb.banking.demo.CustomerNotFoundException;
import se.ecutbildning.javawebb.banking.demo.DummyDatabase;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Customer;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private DummyDatabase db;

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("customers", db.getCustomers());
        return "customer/list";
    }

    @GetMapping("findById/{customerid}")
    public String findById(@PathVariable Long customerid, Model model) {
        int index = db.getCustomers().indexOf(new Customer(customerid));
        if(index == -1) {
            throw new CustomerNotFoundException();
        }
        model.addAttribute("customer", db.getCustomers().get(index));
        return "customer/view";
    }

    // När denna är bortkommenterad kommer html-filen under templates/error/4xx.html användas istället
    /*@ExceptionHandler(CustomerNotFoundException.class)
    public String handleException(HttpServletResponse resp, Exception ex) {
        resp.setStatus(404);
        return "customererror";
    }*/
}
