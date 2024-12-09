package _4.web5.pae.model;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import static org.junit.jupiter.api.Assertions.*;

public class CoursTest {

    private final Validator validator;

    public CoursTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testValidCours() {
        Cours cours = new Cours();
        cours.setCode("MATH101");
        cours.setIntitule("Mathematics");
        cours.setCredits(3);

        assertTrue(validator.validate(cours).isEmpty(), "Cours should be valid");
    }

    @Test
    void testInvalidCours() {
        Cours cours = new Cours();
        cours.setCode("");
        cours.setIntitule("");
        cours.setCredits(-1);

        assertFalse(validator.validate(cours).isEmpty(), "Cours should be invalid");
    }
}
