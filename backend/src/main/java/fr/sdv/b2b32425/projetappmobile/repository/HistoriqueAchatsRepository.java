package fr.sdv.b2b32425.projetappmobile.repository;


import fr.sdv.b2b32425.projetappmobile.bo.HistoriqueAchats;
import fr.sdv.b2b32425.projetappmobile.bo.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueAchatsRepository extends JpaRepository<HistoriqueAchats, Long> {
    List<HistoriqueAchats> findByUtilisateurId(Integer utilisateurId);
}
