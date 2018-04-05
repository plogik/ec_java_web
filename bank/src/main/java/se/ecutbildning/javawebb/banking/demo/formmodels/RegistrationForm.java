package se.ecutbildning.javawebb.banking.demo.formmodels;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm implements Validator {
    @NotNull
    @Size(min=8, max=255)
    private String email;

    @NotNull
    @Size(min=8, max=255)
    private String password;

    @NotNull
    @Size(min=8, max=255)
    private String confirmPassword;

    @NotNull
    @Size(min=8, max=255)
    private String fullName;

    public String getEmail() {
        return email;
    }

    public RegistrationForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationForm setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegistrationForm setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegistrationForm setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationForm.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegistrationForm formData = (RegistrationForm)o;

        if(!formData.getPassword().equals(formData.getConfirmPassword())) {
            errors.rejectValue("password", "registration.pwds_does_not_match");
        }
    }
}
