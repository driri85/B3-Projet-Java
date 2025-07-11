package fr.sdv.b2b32425.projectsemaine2;

import fr.sdv.b2b32425.projectsemaine2.bo.Fournisseur;
import fr.sdv.b2b32425.projectsemaine2.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectSemaine2Application implements CommandLineRunner {
	@Autowired
	private FournisseurRepository dao;

	public static void main(String[] args) {

		SpringApplication.run(ProjectSemaine2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Fournisseur fournisseur = dao.findById(5).get();
		System.out.println(fournisseur);
		Fournisseur fournisseur2 = dao.getId();
		System.out.println(fournisseur2);

	}
}
