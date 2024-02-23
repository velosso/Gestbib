package com.example.Gesbib.dto;

import com.example.Gesbib.model.Adherent;
import com.example.Gesbib.model.Bibliothequaire;
import com.example.Gesbib.model.Compte;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Builder
@Data
public class CompteDto {

    private Integer id;
    private String Login;

    private String Password;

    private List<BibliothequaireDto> bibliothequaire;

    private List<AdherentDto> adherent;

    public static CompteDto fromEntity(Compte compte){
        if(compte == null){
            return null;
        }

        return  CompteDto.builder()
                .id(compte.getId())
                .Login(compte.getLogin())
                .Password(compte.getPassword())
                .build();
    }

    public static Compte toEntity(CompteDto compteDto){
        if(compteDto == null){
            return null;
        }
        Compte compte = new Compte();
        compte.setId(compteDto.getId());
        compte.setLogin(compteDto.getLogin());
        compte.setPassword(compteDto.getPassword());
        return compte;
    }
}
