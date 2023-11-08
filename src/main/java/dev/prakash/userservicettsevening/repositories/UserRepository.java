package dev.prakash.userservicettsevening.repositories;

import dev.prakash.userservicettsevening.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    User findUserById(Long id);
    User findUserByEmail(String email);
}
