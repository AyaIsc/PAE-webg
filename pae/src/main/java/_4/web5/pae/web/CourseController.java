package _4.web5.pae.web;




import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import _4.web5.pae.model.Cours;
import _4.web5.pae.model.Student;
import _4.web5.pae.service.PAEService;
import jakarta.validation.Valid;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;




@Controller
public class CourseController {
    private final PAEService paeService;
    // injecter le service : 
    public CourseController(PAEService paeService){
        this.paeService = paeService;
    }

    @GetMapping("/courses")
    public String getCourse(Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isStudent = authentication.getAuthorities().stream()
                                        .anyMatch(auth -> auth.getAuthority().equals("STUDENT"));

        Iterable<Cours> courses;

        if (isStudent) {
            // Si l'utilisateur est un étudiant, récupérer ses cours
            int matricule = Integer.parseInt(principal.getName());
            Optional<Student> student = paeService.getStudentByMatricule(matricule);
            if (student.isPresent()) {
                courses = student.get().getCours();
            } else {
                // Si aucun étudiant trouvé avec ce matricule, retourner une liste vide
                courses = List.of();
            }
        } else {
            // Sinon, retourner tous les cours
            courses = paeService.getAllCours();
        }

        model.addAttribute("courses", courses);
        model.addAttribute("newCours", new Cours());
        return "courses"; // Fait référence au template `courses.html`
    }

    

    // si optional , je dois gerer l'absence de valeur !!!!
    @GetMapping("/details/{codeC}")
    public String getCoursDetail(@PathVariable("codeC") String codeC, Model model) {
        Optional<Cours> cours = paeService.getCoursByCode(codeC);
        Collection<Student> students = paeService.getStudentsByCours(codeC);
        if (cours.isPresent()) {
            model.addAttribute("cours", cours.get());
            model.addAttribute("students", students);
            return "details"; // on va vers la page details 
        } else {
            System.out.println("Le cours avec le code " + codeC + " n'existe pas.");
            model.addAttribute("errorMessage", "Le cours avec le code " + codeC + " n'existe pas.");
            return "error";
        }
        /*else {
            // SINON -> cas de cours qui existe pas -> redirection
            model.addAttribute("errorMessage", "Le cours avec le code " + codeC + " n'existe pas.");
            return "redirect:/courses"; 
        }*/
    }
    
    @PreAuthorize("hasRole('ROLE_SECRETARIAT')")
    @PostMapping("/courses/add")
        public String addCourse(@Valid Cours newCours, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", paeService.getAllCours());
            return "courses";  // Renvoie à la page des cours avec les erreurs
        }
        paeService.addCours(newCours);
        return "redirect:/courses";
    }

    

}
