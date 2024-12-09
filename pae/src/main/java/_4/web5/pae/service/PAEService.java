package _4.web5.pae.service;



import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import _4.web5.pae.db.CourseDB;
import _4.web5.pae.db.StudentDB;
import _4.web5.pae.model.Cours;
import _4.web5.pae.model.Student;


@Service
public class PAEService {
    private final CourseDB courseDB;
    private final StudentDB studentDB;

    public PAEService(CourseDB courseDB, StudentDB studentDB){
        this.courseDB = courseDB;
        this.studentDB = studentDB;
    }
    public Iterable<Cours> getAllCours(){
        return courseDB.findAll();
    }
    public Optional<Cours> getCoursByCode(String codeC){
        return courseDB.findByCode(codeC);
    }
    public Collection<Student> getStudentsByCours(String codeC){
        return courseDB.findByCode(codeC).get().getStudents();
    }

    public void addCours(Cours newCours) {
        
        courseDB.save(newCours); 
    }
    public Iterable<Student> getStudents(){
        return studentDB.findAll();
    }

    public void addStudent(Student student) {
        studentDB.save(student); 
    }
    public Optional<Student> getStudentByMatricule(int matricule) {
        return studentDB.findById(matricule);
    }
    public List<Object[]> getAllStudentIdsAndNames() {
        return studentDB.findAllStudentIdsAndNames();
    }

    public List<Object[]> getStudentNamesWithTotalCredits() {
        return studentDB.findStudentNamesWithTotalCredits();
    }

    public List<Student> getStudentsWithMoreThanCredits(int minCredits) {
        return studentDB.findStudentsWithMoreThanCredits(minCredits);
    }
    
    public Iterable<Student> getStudentsByName(String name) {
        return studentDB.findByNomContaining(name);  
    }
    
    
}
