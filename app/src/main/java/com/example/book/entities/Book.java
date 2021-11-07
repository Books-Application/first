package com.example.book.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
@Entity(tableName = "table_Book")
public class Book {
    @PrimaryKey(autoGenerate = true)
 private int bookid;
    @ColumnInfo
 private String nom;
    @ColumnInfo
 private String categorie;
    @ColumnInfo
 private double prix;
    @ColumnInfo
    private int image ;
    @ColumnInfo
 private String auteur;
    @ColumnInfo
 private int fav;

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

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

    public Book(String nom, String categorie, double prix, String auteur) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.auteur = auteur;
        fav =0;
    }



    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    }

