package _4.web5.pae.model.bidirectionnel;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

//dù changer de nom car c'est un nom resservé 
@Entity
@Data
public class OrderKiabi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // si ici , nouvelle table , cutsomer est maitre de relation
    //car clé etrangére ps suffisante
    // pas le mapped by -> changement dans la db 
    @ManyToOne
    private Customer customer;  
    
}
