package se.ecutbildning.javawebb.banking.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.ecutbildning.javawebb.banking.demo.DummyDatabase;
import se.ecutbildning.javawebb.banking.demo.domain.entities.Customer;

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

        }
        model.addAttribute("customer", db.getCustomers().get(index));
        return "customer/view";
    }
}
