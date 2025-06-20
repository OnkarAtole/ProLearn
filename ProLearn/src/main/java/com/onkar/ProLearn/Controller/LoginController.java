package com.onkar.ProLearn.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/index")
    public String showLoginPage() {
        return "index"; // This will load login.html
    }

    @GetMapping("/")
    public String home() {
        return "login"; // This will load index.html
    }

    @GetMapping("/home")
    public String dashboard() {
        return "home"; // This will load home.html
    }
    @GetMapping("/file")
    public String file() {
        return "file"; // This will load home.html
    }
    @GetMapping("/todolist")
    public String todolist() {
        return "todolist"; // This will load home.html
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/"; // Redirects to login page after logout
    }
}
