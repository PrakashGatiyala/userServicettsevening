package dev.prakash.userservicettsevening.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Session extends BaseModel{
    // S: U
    // 1: 1
    // M : 1
    // So M : 1
    @ManyToOne
    private User user;
    private String token;

}
