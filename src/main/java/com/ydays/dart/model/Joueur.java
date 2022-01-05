package com.ydays.dart.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "joueurs")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private int ordre;

    private String score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Joueur(){};

    public Joueur(Long id, String nom, int ordre, String score) {
        this.id = id;
        this.nom = nom;
        this.ordre = ordre;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(id, joueur.id) && Objects.equals(nom, joueur.nom) && Objects.equals(ordre, joueur.ordre) && Objects.equals(score, joueur.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, ordre, score);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ordre='" + ordre + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
