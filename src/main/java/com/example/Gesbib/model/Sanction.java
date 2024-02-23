package com.example.Gesbib.model;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="sanction")


public class Sanction extends AbstractEntity{

    @Column(name="type_sanction")
    private String Type_Sanction;

    @Column(name="motif")
    private String Motif;

    @ManyToOne
    @JoinColumn(name ="idposseder")
    private Posseder posseder;


}
