package fr.sdv.b2b32425.projectsemaine2.repository;

import fr.sdv.b2b32425.projectsemaine2.bo.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    Fournisseur getId();
}
