package _4.web5.pae.model;


import java.util.Collection;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;

@Data // data - ajouter automatiquement getter et setter 
@Entity
@Table(name = "COURS")
public class Cours {

    @Id
    @NotBlank(message = "Le code du cours est obligatoire.")
    private String code;

    @NotBlank(message = "L'intitulé du cours est obligatoire.")
    @Column(name = "intitule") 
    private String intitule;

    @Positive(message = "Les crédits doivent être supérieurs à zéro.")
    private int credits;

    // mappedy = je ne suis PAS le maitre
    // maitre = c'es lui qui possède la clé étrangere 
    // fetch = la relation est chargée immediatmeent quand on recupère (eager) l'entité dans la base de donnée
    // .LAZY : quand on en a besoin
    // pas de mappedby -> 2 liens differents
    // *--* = pas de mapped by
    // celui où on apas le mapped by on fai tle "save" dans controller /!\
    // difference entre 1 et 1..* avec optional
    @ManyToMany(mappedBy = "cours", fetch=FetchType.EAGER)
    @ToString.Exclude // N'inclut pas les étudiants dans la méthode toString
    @JsonManagedReference
    private Collection<Student> students;
}
