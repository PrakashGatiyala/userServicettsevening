package dev.prakash.userservicettsevening.services;

import dev.prakash.userservicettsevening.models.Session;
import dev.prakash.userservicettsevening.models.User;
import dev.prakash.userservicettsevening.repositories.SessionRepository;
import dev.prakash.userservicettsevening.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    AuthServiceImpl(UserRepository userRepository, SessionRepository sessionRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }
    String generateRandomToken(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(20);
        for (int i = 0; i < 20; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    @Override
    public String login(String email, String password, String firstName, String lastName) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        // Print user
        System.out.println(user);
        userRepository.save(user);
        String token = generateRandomToken();
        Session session = new Session();
        session.setToken(token);
        session.setUser(user);
        sessionRepository.save(session);
        return token;
    }

    @Override
    public String validate(String token) {
        Session session = sessionRepository.findSessionByToken(token);
        if(session != null){
            return "Successfully validated";
        }
        return "Invalid token";
    }
}
