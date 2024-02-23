package com.example.Gesbib.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Instant;



@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="adherent")
public class Adherent extends AbstractEntity {

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

    @Column(name ="typeAdhesion")
    private String typeAdhesion;

    @Column(name ="dateadhesion")
    private Instant DateAdhesion;

    @ManyToOne
    @JoinColumn(name = "idemprunter")
    private Emprunter emprunter;

    @ManyToOne
    @JoinColumn(name = "idreserver")
    private Reserver reserver;

    @ManyToOne
    @JoinColumn(name ="idposseder")
    private Posseder posseder;

    @ManyToOne
    @JoinColumn(name="idcompte")
    private Compte compte;


}
