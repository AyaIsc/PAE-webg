package _4.web5.pae.web;


import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import _4.web5.pae.model.Student;
import _4.web5.pae.service.PAEService;
import jakarta.validation.Valid;

@Controller
public class StudentController {
    private final PAEService paeService;
    
    public StudentController(PAEService paeService){
        this.paeService = paeService;
    }

 
    

    @GetMapping("/students")
    public String getStudents(@RequestParam(value = "name", required = false) String nom, Model model) {
        Iterable<Student> studentList;


        if (nom != null && !nom.isEmpty()) {
            studentList = paeService.getStudentsByName(nom);  
        } else {
        
            studentList = paeService.getStudents();  
        }

        model.addAttribute("newStudent", new Student());
        model.addAttribute("studentsList", studentList);  
        return "students";  
    }

    @GetMapping("/course/{code}/students")
    public String getCourseStudents(@PathVariable String code, Model model) {
        Iterable<Student> studentsList = paeService.getStudentsByCours(code);
        model.addAttribute("studentsList", studentsList);
        return "course-details";  
    }

    @PreAuthorize("hasRole('SECRETARIAT')")
    @PostMapping("/students/add")
    public String addStudent(@Valid Student newStudent, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("newStudent", newStudent);  // on renvoie le student avec les erors
            model.addAttribute("studentsList", paeService.getStudents());  // on renvoie la liste d'etudaint
            return "students";  
        }
        paeService.addStudent(newStudent);
        return "redirect:/students";
    }
    
    @GetMapping("/student/{matricule}")
    public String getStudentDetails(@PathVariable int matricule, Model model) {
        Optional<Student> studentOpt = paeService.getStudentByMatricule(matricule);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            System.out.println("Étudiant trouvé : " + student);  
            model.addAttribute("student", student);
            model.addAttribute("coursesList", student.getCours());
            System.out.println("Nombre de cours pour l'étudiant : " + student.getCours().size());

            return "student-details"; 
        } else {
            System.out.println("Étudiant non trouvé pour matricule : " + matricule);  // Débogage
            return "error"; 
        }
        
    }

    /*@GetMapping("/pae")
    public String showStudentPae(Model model, Principal principal) {
        String username = principal.getName(); // Récupère le nom d'utilisateur connecté
        Iterable<Student> student = paeService.getStudentsByName(username); // Trouver l'étudiant
        model.addAttribute("pae", student.getPae()); // Ajouter le PAE au modèle
        return "studentPAE";
    }*/

    /*@GetMapping("/pae")
    public String showStudentPae(Model model, Principal principal) {
        // nom= correspond au matricule
        String username = principal.getName();

        try {
            // conversion
            int matricule = Integer.parseInt(username);

            
            Optional<Student> student = paeService.getStudentByMatricule(matricule);

            if (student.isPresent()) {
                // on ajoute les cours de l'étudiant au modèle
                model.addAttribute("pae", student.get().getCours());
                return "student-pae"; // Vue spécifique à l'étudiant
            } else {
                // si l'étudiant n'est pas trouvé ----> ajoute un message d'erreur
                model.addAttribute("errorMessage", "Étudiant non trouvé pour le matricule " + matricule);
                return "error"; 
            }
        } catch (NumberFormatException e) {
          
            model.addAttribute("errorMessage", "Le matricule fourni n'est pas valide : " + username);
            return "error";
        }
    }*/




}
