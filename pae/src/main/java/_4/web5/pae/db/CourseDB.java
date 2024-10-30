package _4.web5.pae.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import _4.web5.pae.model.Cours;


@Repository
public interface CourseDB extends CrudRepository<Cours,String> {

} 
