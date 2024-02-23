package com.example.Gesbib.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Bibliothequaire extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name ="dateNaissance")
    private Date dateNaissance;

    @Column(name ="numTel")
    private String numTel;

    @Column(name = "email")
    private String email;

    @Column(name="adress")
    private String adress;

    @ManyToOne
    @JoinColumn(name = "idcompte")
    private Compte compte;






}
