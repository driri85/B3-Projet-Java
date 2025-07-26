package fr.sdv.b2b32425.projetappmobile.repository;


import fr.sdv.b2b32425.projetappmobile.bo.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Integer> {
    Utilisateurs findByNom(String nom);
}

