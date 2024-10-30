package _4.web5.pae.service.old;

/*import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _4.web5.pae.db.repository.CoursRepository;
import _4.web5.pae.db.repository.StudentRepository;
import _4.web5.pae.model.Cours;
import _4.web5.pae.model.Student;
*/

/* 
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CoursRepository coursRepository;

    public void createStudent(String nom) {
        Student student = new Student();
        student.setNom(nom);
        studentRepository.save(student);
    }

    public void displayStudentCourses(String matricule) {
        Optional<Student> optionalStudent = studentRepository.findByMatricule(matricule);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.println("Nom de l'étudiant : " + student.getNom());
            System.out.println("Liste des cours :");

            for (Cours cours : student.getCours()) {
                System.out.println("- " + cours.getIntitule());
            }
        } else {
            System.out.println("Étudiant avec le matricule " + matricule + " non trouvé.");
        }
    }

    public void enrollStudentInCourse(String matricule, String codeCours) {
        Optional<Student> optionalStudent = studentRepository.findByMatricule(matricule);
        Optional<Cours> optionalCours = coursRepository.findByCode(codeCours);

        if (optionalStudent.isPresent() && optionalCours.isPresent()) {
            Student student = optionalStudent.get();
            Cours cours = optionalCours.get();

            student.getCours().add(cours);
            studentRepository.save(student);

            System.out.println("L'étudiant " + student.getNom() + " a été inscrit au cours " + cours.getIntitule());
        } else {
            if (!optionalStudent.isPresent()) {
                System.out.println("Étudiant avec le matricule " + matricule + " non trouvé.");
            }
            if (!optionalCours.isPresent()) {
                System.out.println("Cours avec le code " + codeCours + " non trouvé.");
            }
        }
    }
}
*/