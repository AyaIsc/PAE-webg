package _4.web5.pae.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Authority {
    @Id
    private long id;
    private String username; 
    private String authority;
}
