package com.example.Gesbib.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="auteur")

public class Auteur extends AbstractEntity{

    @Column(name="nom")
    private String Nom;

    @Column(name = "prenom")
    private String Prenom;

    @OneToMany(mappedBy = "auteur")
    private List <Livre> livre;

}
