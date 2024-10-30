package _4.web5.pae.model;



import java.util.Collection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String matricule;
    private String nom;

    /*@Enumerated
    private String genre;

    @Enumerated
    private String section;
    */
    
    @ManyToMany
    // pour mes insert c'est + prudent pour les changements de noms (att , class)
    @JoinTable(
        name = "student_cours",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "cours_id")
    )

    private Collection<Cours> cours;

    public Collection<Cours> getCours() {
        return cours;
    }

    public Long getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
