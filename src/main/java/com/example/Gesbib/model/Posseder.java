package com.example.Gesbib.model;

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
@Table(name="posserder")

public class Posseder extends AbstractEntity {

    @OneToMany(mappedBy = "posseder")
    private List<Adherent> adherent;

    @OneToMany(mappedBy = "posseder")
    private List<Sanction> sanction;
}
