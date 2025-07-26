package fr.sdv.b2b32425.projetappmobile.repository;


import fr.sdv.b2b32425.projetappmobile.bo.UtilisateurListe;
import fr.sdv.b2b32425.projetappmobile.bo.UtilisateurListeId;
import fr.sdv.b2b32425.projetappmobile.bo.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateursListeRepository extends JpaRepository<UtilisateurListe, UtilisateurListeId> {}

