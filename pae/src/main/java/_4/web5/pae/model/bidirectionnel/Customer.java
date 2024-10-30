package _4.web5.pae.model.bidirectionnel;

import java.util.Collection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // fait refernce à l'autre attribut de l'AUTRE CLASSE
    //l'autre classe possède une clé étrangèere
    // nous pouvons supprimer cela mais ça nous interdit les guetter
    @OneToMany(mappedBy="customer") 
    private Collection<OrderKiabi> orders;


  
    // cree une clé etrangere dans order

    //suivant où je place le mappedby = diff resultats 

    //solution plus facile -> clé étrangère  

}
