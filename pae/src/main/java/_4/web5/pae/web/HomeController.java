package _4.web5.pae.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Principal principal) {
        System.out.println(principal); // principal nous permet de recuperer la personne connecté
        return "home";  // fait ref a home.html
    }

    @GetMapping("/private")
    public String privateSection() {
        return "private";
    }
   
}
