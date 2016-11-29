package com.example.robin.appliprojet.casee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 28/11/16.
 */

public class Case {
    private int image;
    private String nom;
    private String text;
    private int prix;
    private String description;
    private List<String> avis;

    public Case(int image, String nom, String text) {
        this.image = image;
        this.nom = nom;
        this.text = text;
        this.avis= new ArrayList<String>();
    }

    public Case(int image, String nom, String text, String description) {
        this.image = image;
        this.nom = nom;
        this.text = text;
        this.description= description;
        this.avis= new ArrayList<String>();
    }

    public Case(int image, String nom, String text, String description, int prix) {
        this.image = image;
        this.nom = nom;
        this.text = text;
        this.description= description;
        this.prix=prix;
        this.avis= new ArrayList<String>();
    }

    public Case(int image, String nom, String text, String description, List<String> avis) {
        this.image = image;
        this.nom = nom;
        this.text = text;
        this.description= description;
        this.avis= new ArrayList<String>();
        this.avis=avis;
    }

    public int getImage() {
        return image;
    }

    public String getNom() {
        return nom;
    }

    public String getText() {
        return text;
    }

    public List<String> getAvis() {return avis;}

    public String getDescription() {
        return description;
    }

    public int getPrix() {
        return prix;
    }

    public void setImage(int color) {
        this.image = image;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvis(List<String> avis) {this.avis = avis;}

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
