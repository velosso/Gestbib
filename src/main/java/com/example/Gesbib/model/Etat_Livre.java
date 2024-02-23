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
@Table(name="etat_livre")

public class Etat_Livre extends AbstractEntity {

    @Column(name="etat")
    private String Etat;

    @OneToMany(mappedBy = "etat_livre")
    private List<Livre> livre;
}
