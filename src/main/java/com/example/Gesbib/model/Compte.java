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
@Table(name="compte")

public class Compte extends AbstractEntity {

    @Column(name = "login")
    private String Login;

    @Column(name="password")
    private String Password;

    @OneToMany(mappedBy = "compte")
    private List<Bibliothequaire> bibliothequaire;

    @OneToMany(mappedBy = "compte")
    private List<Adherent> adherent;
}
