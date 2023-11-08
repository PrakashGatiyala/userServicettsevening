package dev.prakash.userservicettsevening.repositories;

import dev.prakash.userservicettsevening.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session save(Session session);
    Session findSessionById(Long id);
    Session findSessionByToken(String token);
}
