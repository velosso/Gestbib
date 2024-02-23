package com.example.Gesbib.model;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="exemplaire")
public class Exemplaire extends AbstractEntity{

    @Column(name = "nbre_exemplaire")
    private Number nbre_Exemplaire;

    @ManyToOne
    @JoinColumn(name = "idreserver")
    private Reserver reserver;
}
