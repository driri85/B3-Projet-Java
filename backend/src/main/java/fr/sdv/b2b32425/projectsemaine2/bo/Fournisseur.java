package fr.sdv.b2b32425.projectsemaine2.bo;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "fournisseur")
public class Fournisseur implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOM")
    private String raionSociale;

    public Fournisseur() {
    }

    public Fournisseur(String raionSociale) {
        this.raionSociale = raionSociale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaionSociale() {
        return raionSociale;
    }

    public void setRaionSociale(String raionSociale) {
        this.raionSociale = raionSociale;
    }
}
