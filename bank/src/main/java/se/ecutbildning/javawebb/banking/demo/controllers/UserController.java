package se.ecutbildning.javawebb.banking.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.ecutbildning.javawebb.banking.demo.formmodels.LoginForm;
import se.ecutbildning.javawebb.banking.demo.formmodels.RegistrationForm;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("login")
    public String login(LoginForm loginForm) {
        return "user/login";
    }

    @PostMapping("login")
    public String login(@Valid LoginForm loginForm, BindingResult result) {
        if(result.hasErrors()) {
            return "user/login";
        }
        // TODO: authenticate user
        return "redirect:/user/welcome";
    }

    @GetMapping("test")
    public String test() {
        throw new RuntimeException("Fel fel fel");
    }

    @GetMapping("welcome")
    public String welcome() {
        return "user/welcome";
    }

    @PostMapping("register")
    public String register(@Valid RegistrationForm registrationForm, BindingResult result) {
        // Jag stoppade in validatorn i formmodellen så den kan validera sig själv istället
        registrationForm.validate(registrationForm, result);

        if(result.hasErrors()) {
            return "user/registration";
        }
        return "redirect:/user/welcome";
    }

    @GetMapping("register")
    public String register(RegistrationForm registrationForm) {
        return "user/registration";
    }
}
