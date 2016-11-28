package com.example.robin.appliprojet.casee;

/**
 * Created by robin on 28/11/16.
 */

public class Case {
    private int image;
    private String nom;
    private String text;
    private String description;

    public Case(int image, String nom, String text) {
        this.image = image;
        this.nom = nom;
        this.text = text;
    }

    public Case(int image, String nom, String text, String description) {
        this.image = image;
        this.nom = nom;
        this.text = text;
        this.description= description;
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

    public String getDescription() {
        return description;
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
}
