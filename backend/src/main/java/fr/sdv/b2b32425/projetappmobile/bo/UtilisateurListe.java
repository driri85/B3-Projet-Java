package fr.sdv.b2b32425.projetappmobile.bo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "utilisateur_liste")
public class UtilisateurListe {

    @EmbeddedId
    private UtilisateurListeId id;

    public UtilisateurListe() {}

    public UtilisateurListe(Integer utilisateurId, Integer listeId) {
        this.id = new UtilisateurListeId(utilisateurId, listeId);
    }

    public UtilisateurListeId getId() { return id; }
    public void setId(UtilisateurListeId id) { this.id = id; }
}
