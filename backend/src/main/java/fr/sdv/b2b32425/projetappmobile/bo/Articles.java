package fr.sdv.b2b32425.projetappmobile.bo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "articles")
public class Articles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "liste_id")
    private Integer listeId;

    private String nom;
    private String quantite;
    private String categorie;
    private String notes;

    @Column(name = "est_achete")
    private boolean estAchete;

    @Column(name = "date_ajout")
    private Timestamp dateAjout;

    public Articles() {}

    // ✅ GETTERS

    public Integer getId() {
        return id;
    }

    public Integer getListeId() {
        return listeId;
    }

    public String getNom() {
        return nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isEstAchete() {
        return estAchete;
    }

    public Timestamp getDateAjout() {
        return dateAjout;
    }

    // ✅ SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setListeId(Integer listeId) {
        this.listeId = listeId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setEstAchete(boolean estAchete) {
        this.estAchete = estAchete;
    }

    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }
}
