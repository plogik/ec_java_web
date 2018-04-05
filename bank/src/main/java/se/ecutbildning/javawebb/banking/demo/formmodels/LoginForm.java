package se.ecutbildning.javawebb.banking.demo.formmodels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
    @NotNull
    @Size(min = 5, max = 255)
    private String username;
    @NotNull
    @Size(min = 5, max = 15)
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginForm setPassword(String password) {
        this.password = password;
        return this;
    }
}
