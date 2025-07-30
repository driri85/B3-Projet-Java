package fr.sdv.b2b32425.projetappmobile;

import fr.sdv.b2b32425.projetappmobile.bo.*;
import fr.sdv.b2b32425.projetappmobile.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class ProjetAppMobileApplication implements CommandLineRunner {

    @Configuration
    public class WebConfig {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                        .allowedOrigins("https://java-frontend.arsdv.site")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
                }
            };
        }
    }

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
