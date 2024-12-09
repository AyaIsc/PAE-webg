package _4.web5.pae.model;



import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Student {
    @Id
    @Positive(message = "Le matricule doit être un nombre positif.")
    private int matricule;

    @NotBlank(message = "Le nom est obligatoire.")
    private String nom;

    private String genre;

    @NotBlank(message = "La section est obligatoire.")
    private String section;
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    // pour mes insert c'est + prudent pour les changements de noms (att , class)
    @JoinTable(
        name = "student_cours",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    
    @ToString.Exclude // N'inclut pas les cours dans la méthode toString
    @JsonIgnore
    private Collection<Cours> cours;

    


}
