package _4.web5.pae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* lance l'app spring boot et c'est ma classe PRINCIPALE */
@SpringBootApplication
public class PaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaeApplication.class, args);
	}
	//comprendre le MVC !!! service 
	//commandliner -> classe de config 
	//commandliner doit appeller service
	//service doit appeller repository
	//repository doit appeller la base de données
	//la base de données est la source de vérité
	
}
