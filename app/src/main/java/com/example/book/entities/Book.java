package com.example.book.entities;

import java.util.Date;

public class Book {
 private int bookid;
 private String nom;
 private String categorie;
 private double prix;
 private int image ;
 private String auteur;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Book(String nom,  String categorie, double prix, int image, String auteur) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.image = image;
        this.auteur = auteur;
    }
}
