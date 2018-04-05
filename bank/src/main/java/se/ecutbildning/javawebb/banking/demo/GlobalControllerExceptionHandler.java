package se.ecutbildning.javawebb.banking.demo;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(RuntimeException.class)
    public String handleAllExceptions(HttpServletResponse resp, Exception ex, Model model) {
        resp.setStatus(404);
        model.addAttribute("message", ex.getMessage());
        return "globalerror";
    }
}
