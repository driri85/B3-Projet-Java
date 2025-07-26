package fr.sdv.b2b32425.projetappmobile.bo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "historique_achats")
public class HistoriqueAchats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateurs utilisateur;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Articles article;

    private LocalDate dateAchat;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Utilisateurs getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateurs utilisateur) { this.utilisateur = utilisateur; }

    public Articles getArticle() { return article; }
    public void setArticle(Articles article) { this.article = article; }

    public LocalDate getDateAchat() { return dateAchat; }
    public void setDateAchat(LocalDate dateAchat) { this.dateAchat = dateAchat; }

}
