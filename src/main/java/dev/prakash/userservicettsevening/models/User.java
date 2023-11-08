package dev.prakash.userservicettsevening.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class User extends BaseModel{
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
