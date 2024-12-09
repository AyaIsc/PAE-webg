package _4.web5.pae;



import _4.web5.pae.service.PAEService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;

/* execute du code APRES que l'app spring ai demarré!*/
@Transactional
//@Component desactiver le code lancé 
public class AppStartupRunner implements CommandLineRunner {

    /*@Autowired
    private StudentService studentService; // Appel au service
    */
    @Autowired
    private PAEService paeService;
    /*@Autowired
    private CoursService coursService; // Appel au service
    */

    @Override
    public void run(String... args) throws Exception {
        paeService.getAllCours().forEach(c -> System.out.println(c.getIntitule()));
       /*  studentService.createStudent("Alice");
        studentService.createStudent("Bob");

        studentService.enrollStudentInCourse("S001", "INT1");
        studentService.enrollStudentInCourse("S002", "ALG3");

        studentService.displayStudentCourses("S001");
        */
        
    }
}
