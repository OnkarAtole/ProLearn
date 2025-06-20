package com.onkar.ProLearn.Controller;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.onkar.ProLearn.service.FirebaseAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @Autowired
    private FirebaseAuthService firebaseAuthService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Returns the Thymeleaf register.html page
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            String userId = firebaseAuthService.registerUser(email, password);
            model.addAttribute("successMessage", "User registered successfully! Please login.");
            return "redirect:/"; // Redirect to login page after successful registration
        } catch (FirebaseAuthException e) {
            model.addAttribute("errorMessage", "Registration failed: " + e.getMessage());
            return "register"; // Stay on the registration page and show the error
        }
    }
}
