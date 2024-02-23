package com.example.Gesbib.dto;



import com.example.Gesbib.model.Bibliothequaire;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Builder
@Data

public class BibliothequaireDto {
    private Integer id;

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private String numTel;

    private String email;

    private String adress;

    private CompteDto compte;

    public static BibliothequaireDto fromEntity(Bibliothequaire bibliothequaire){
        if(bibliothequaire == null){
            return null;
        }
        return  BibliothequaireDto.builder()
                .id(bibliothequaire.getId())
                .nom(bibliothequaire.getNom())
                .prenom(bibliothequaire.getPrenom())
                .numTel(bibliothequaire.getNumTel())
                .email(bibliothequaire.getEmail())
                .adress(bibliothequaire.getAdress())
                .build();
    }

    public static Bibliothequaire toEntity(BibliothequaireDto bibliothequaireDto){
        if(bibliothequaireDto == null){
            return null;
        }
        Bibliothequaire bibliothequaire = new Bibliothequaire();
        bibliothequaire.setId(bibliothequaireDto.getId());
        bibliothequaire.setNom(bibliothequaireDto.getNom());
        bibliothequaire.setPrenom(bibliothequaireDto.getPrenom());
        bibliothequaire.setNumTel(bibliothequaireDto.getNumTel());
        bibliothequaire.setEmail(bibliothequaireDto.getEmail());
        bibliothequaire.setAdress(bibliothequaireDto.getAdress());
        return bibliothequaire;
    }
}
