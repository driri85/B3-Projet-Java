package fr.sdv.b2b32425.projetappmobile.bo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class UtilisateurListeId implements Serializable {

    @Column(name = "utilisateur_id")
    private Integer utilisateurId;

    @Column(name = "liste_id")
    private Integer listeId;

    public UtilisateurListeId() {}

    public UtilisateurListeId(Integer utilisateurId, Integer listeId) {
        this.utilisateurId = utilisateurId;
        this.listeId = listeId;
    }

    // ✅ Obligatoire : equals() et hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtilisateurListeId)) return false;
        UtilisateurListeId that = (UtilisateurListeId) o;
        return Objects.equals(utilisateurId, that.utilisateurId) &&
                Objects.equals(listeId, that.listeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateurId, listeId);
    }

    // Getters et Setters
}
