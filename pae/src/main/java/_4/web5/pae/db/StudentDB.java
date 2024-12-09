package _4.web5.pae.db;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import _4.web5.pae.model.Student;

@Repository
public interface StudentDB extends CrudRepository<Student,Integer>{
    

    @Query("SELECT s.nom FROM Student s")  
    List<String> findAllStudentNames();

    @Query("SELECT s.matricule, s.nom FROM Student s")  
    List<Object[]> findAllStudentIdsAndNames();

    @Query("SELECT s.nom, SUM(c.credits) FROM Student s JOIN s.cours c GROUP BY s.nom")  
    List<Object[]> findStudentNamesWithTotalCredits();

    @Query("SELECT s FROM Student s JOIN s.cours c GROUP BY s HAVING SUM(c.credits) > :minCredits")
    List<Student> findStudentsWithMoreThanCredits(@Param("minCredits") int minCredits);

    @Query("SELECT s FROM Student s WHERE LOWER(s.nom) LIKE LOWER(CONCAT('%', :nom, '%'))")
    Iterable<Student> findByNomContaining(@Param("nom") String nom);

}
