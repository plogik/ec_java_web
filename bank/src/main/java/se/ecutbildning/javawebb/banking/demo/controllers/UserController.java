package se.ecutbildning.javawebb.banking.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView();
    }

    @PostMapping("login")
    public String login(@RequestParam(required = false) String username,
                              @RequestParam(required = false) String password) {
        // TODO: authenticate user
        return "redirect:/user/welcome";
    }

    @GetMapping("welcome")
    public String welcome() {
        return "user/welcome";
    }
}
