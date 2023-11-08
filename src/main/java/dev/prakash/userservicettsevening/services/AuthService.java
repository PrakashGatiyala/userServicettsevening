package dev.prakash.userservicettsevening.services;

public interface AuthService {
    String login(String email, String password, String firstName, String lastName);
    String validate(String token);
}
