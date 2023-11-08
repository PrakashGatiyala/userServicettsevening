package dev.prakash.userservicettsevening.controllers;

import dev.prakash.userservicettsevening.services.AuthService;
import dev.prakash.userservicettsevening.services.AuthServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private AuthService authService;
    AuthController(AuthService authService){
        this.authService = authService;
    }
    @GetMapping("/login/{email}/{password}/{firstName}/{lastName}")
    String login(@PathVariable("email") String email,
                 @PathVariable("password") String password,
                 @PathVariable("firstName") String firstName,
                 @PathVariable("lastName") String lastName){
        return "Token Generated: "+ authService.login(email, password, firstName, lastName);
    }
    @GetMapping("/validate/{token}")
    String validate(@PathVariable("token") String token){
        return authService.validate(token);
    }
}
