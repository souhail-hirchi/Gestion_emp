package com.groupe10.GestionEmp.entité;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Table(name ="EMPLOYEES")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NOM",length=30, nullable = false )
    private String nom;

    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date dateNaissance;

    @Column(nullable = false, unique = true)
    private String email;
    private String fonction;

//Constructeur par defaut
    public Employe(int id, String nom, Date dateNaissance, String email, String fonction) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.fonction = fonction;
    }
//Constructeur par defaut par defaut
    public Employe() {}

    // Getters & Setters
    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getNom() { return nom;}

    public void setNom(String nom) { this.nom = nom;}

    public String getEmail() { return email;}

    public void setEmail(String email) { this.email = email;}

    public String getFonction() { return fonction;}

    public void setFonction(String fonction) { this.fonction = fonction;}

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", email='" + email + '\'' +
                ", fonction='" + fonction + '\'' +
                '}';
    }
}
