package com.example.Gesbib.dto;

import com.example.Gesbib.model.*;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@Builder
@Data
public class AuteurDto {
    private Integer id;

    private String Nom;

    private String Prenom;

    private List<LivreDto> livre;

    private EmprunterDto emprunter;

    private ReserverDto reserver;

    private PossederDto posseder;

    private CompteDto compte;

    public static AuteurDto fromEntity (Auteur auteur){
        if(auteur == null){
            return null;
        }
        return AuteurDto.builder()
                .id(auteur.getId())
                .Nom(auteur.getNom())
                .Prenom(auteur.getPrenom())
                .build();
    }

    public static Auteur toEntity(AuteurDto auteurDto){
        if(auteurDto == null){
            return null;
        }
        Auteur auteur = new Auteur();
        auteur.setId(auteurDto.getId());
        auteur.setNom(auteurDto.getNom());
        auteur.setPrenom(auteurDto.getPrenom());
        return auteur;
    }
}
