package com.example.book.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "table_User")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int iduser;
    @ColumnInfo
    private String nom;
    @ColumnInfo
    private String password;
    @ColumnInfo
    private String email;

    public User(String nom, String password, String email) {
        this.nom = nom;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
