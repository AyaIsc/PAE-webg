package _4.web5.pae.web;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import _4.web5.pae.model.Cours;
import _4.web5.pae.service.PAEService;
import java.util.Optional;


@Controller
public class CourseController {
    private final PAEService paeService;
    // injecter le service : 
    public CourseController(PAEService paeService){
        this.paeService = paeService;
    }

    @GetMapping("/courses")
    public String getCourse(Model model){
        Iterable<Cours> courses = paeService.getAllCours();
        //System.out.println("les intitules "+courses.get(0).getIntitule());
        model.addAttribute("courses",courses);
        return "courses"; // fait reference au template courses.html
        // on retourne la vue
    }


    // si optional , je dois gerer l'absence de valeur !!!!
    @GetMapping("/details/{codeC}")
    public String getCoursDetail(@PathVariable("codeC") String codeC, Model model) {
        Optional<Cours> cours = paeService.getCoursByCode(codeC);
        System.out.println("le cours ets !!" + cours.get());
        if (cours.isPresent()) {
            model.addAttribute("cours", cours.get());
            return "details"; // on va vers la page details 
        } else {
            // SINON -> cas de cours qui existe pas -> redirection
            model.addAttribute("errorMessage", "Le cours avec le code " + codeC + " n'existe pas.");
            return "redirect:/courses"; 
        }
    }
    
    

}
