package fr.sdv.b2b32425.projetappmobile;

import fr.sdv.b2b32425.projetappmobile.bo.*;
import fr.sdv.b2b32425.projetappmobile.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjetAppMobileApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjetAppMobileApplication.class, args);
    }

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private HistoriqueAchatsRepository historiqueAchatsRepository;

    @Autowired
    private UtilisateursListeRepository utilisateurListeRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
