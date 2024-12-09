package _4.web5.pae.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {
    @Id
    private String username;
    private String password;
    private boolean enabled; // Détermine si le compte est activé ou non
}
