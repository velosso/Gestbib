package com.example.Gesbib.dto;

import com.example.Gesbib.model.Adherent;
import com.example.Gesbib.model.Categorie;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.Instant;

@Builder
@Data
public class AdherentDto {
    private Integer id;

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private String numTel;

    private String email;

    private String adress;

    private String typeAdhesion;

    private Instant DateAdhesion;

    public static AdherentDto fromEntity(Adherent adherent){
        if(adherent == null){
            return null;
        }
        return AdherentDto.builder()
                .id(adherent.getId())
                .nom(adherent.getNom())
                .prenom(adherent.getPrenom())
                .DateAdhesion(adherent.getDateAdhesion())
                .typeAdhesion(adherent.getTypeAdhesion())
                .dateNaissance(adherent.getDateNaissance())
                .numTel(adherent.getNumTel())
                .email(adherent.getEmail())
                .adress(adherent.getAdress())
                .build();
    }

    public static Adherent toEntity(AdherentDto adherentDto){
        if(adherentDto == null){
            return null;
        }

        Adherent adherent = new Adherent();
       adherent.setId(adherentDto.getId());
       adherent.setNom(adherentDto.getNom());
       adherent.setPrenom((adherentDto.getPrenom()));
       adherent.setDateAdhesion(adherentDto.getDateAdhesion());
       adherent.setTypeAdhesion(adherentDto.getTypeAdhesion());
       adherent.setDateNaissance(adherentDto.getDateNaissance());
       adherent.setNumTel(adherentDto.getNumTel());
       adherent.setEmail(adherentDto.getEmail());
       adherent.setAdress(adherentDto.getAdress());

        return adherent;
    }
}
