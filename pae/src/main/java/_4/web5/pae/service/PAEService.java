package _4.web5.pae.service;



import org.springframework.stereotype.Service;
import java.util.Optional;
import _4.web5.pae.db.CourseDB;
import _4.web5.pae.model.Cours;

@Service
public class PAEService {
    private final CourseDB courseDB;

    public PAEService(CourseDB courseDB){
        this.courseDB = courseDB;
    }
    public Iterable<Cours> getAllCours(){
        return courseDB.findAll();
    }
    public Optional<Cours> getCoursByCode(String id){
        return courseDB.findById(id);
    }

}
