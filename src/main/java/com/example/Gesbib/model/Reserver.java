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
@Table(name="reserver")

public class Reserver extends AbstractEntity {
    @Column(name="demande_r")
    private String Demande_R;

    @Column(name="annulation_r")
    private String Annulation_R;

    @Column(name="date_reservation")
    private String Date_Reservation;

    @OneToMany(mappedBy = "reserver")
    private List <Adherent> adherent;

    @OneToMany(mappedBy = "reserver")
    private List <Exemplaire> exemplaire;
}
