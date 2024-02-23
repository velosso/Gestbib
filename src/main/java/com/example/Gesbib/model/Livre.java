package com.example.Gesbib.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="livre")
public class Livre extends AbstractEntity {

    @Column(name ="titre")
    private String titre;

    @Column(name = "isbn")
    private String Isbn;

    @Column(name="date_edition")
    private Date Date_Edition;

    @ManyToOne
    @JoinColumn(name = "idemprunter")
    private Emprunter emprunter;

    @ManyToOne
    @JoinColumn(name = "idetat_livre")
    private Etat_Livre etat_livre;

    @ManyToOne
    @JoinColumn(name = "idauteur")
    private Auteur auteur;

    @ManyToOne
    @JoinColumn(name = "idcategorie")
    private Categorie categorie;
}
