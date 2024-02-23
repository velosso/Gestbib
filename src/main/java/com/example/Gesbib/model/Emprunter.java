package com.example.Gesbib.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="emprunter")
public class Emprunter extends AbstractEntity {

    @Column(name="date_emprunt")
    private Date Date_Emprunt;

    @Column(name="date_retour")
    private Date Date_Retour;

    @OneToMany(mappedBy = "emprunter")
    private List<Adherent> adherent;

    @OneToMany(mappedBy = "emprunter")
    private List<Livre> livre;

}
