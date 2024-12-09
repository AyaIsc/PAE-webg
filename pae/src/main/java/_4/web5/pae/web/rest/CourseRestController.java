package _4.web5.pae.web.rest;

import org.springframework.web.bind.annotation.RestController;

import _4.web5.pae.model.Cours;
import _4.web5.pae.service.PAEService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {
    private final PAEService paeService;

    public CourseRestController(PAEService paeService) {
        this.paeService = paeService;
    }

    @GetMapping("/courses")
    public List<Cours> getAllCourses() {
        return (List<Cours>) paeService.getAllCours();
    }
}
