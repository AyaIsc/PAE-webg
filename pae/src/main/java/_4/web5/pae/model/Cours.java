package _4.web5.pae.model;


import java.util.Collection;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data // data - ajouter automatiquement getter et setter 
@Entity
@Table(name = "COURS")
public class Cours {

    @Id
    @SequenceGenerator(name = "cours_seq", sequenceName = "cours_sequence", initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cours_seq")
    private String id;

    private String code;

   
    private String intitule;

    private String credits;

    // mappedy = je ne suis PAS le maitre
    // maitre = c'es lui qui possède la clé étrangere 
    // fetch = la relation est chargée immediatmeent quand on recupère (eager) l'entité dans la base de donnée
    // .LAZY : quand on en a besoin
    // pas de mappedby -> 2 liens differents
    @ManyToMany(mappedBy = "cours", fetch=FetchType.EAGER)
    private Collection<Student> students;
}
