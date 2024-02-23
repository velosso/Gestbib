package com.example.Gesbib.dto;


import com.example.Gesbib.model.Livre;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class LivreDto {
    private Integer id;
    private String titre;

    private String Isbn;


    private Date Date_Edition;


    private EmprunterDto emprunter;


    private Etat_LivreDto etat_livre;


    private AuteurDto auteur;


    private CategorieDto categorie;

    public static LivreDto fromEntity(Livre livre){
        if(livre == null){
            return null;
        }
        return LivreDto.builder()
                .id(livre.getId())
                .Isbn(livre.getIsbn())
                .Date_Edition(livre.getDate_Edition())
                .build();
    }

    public static Livre toEntity(LivreDto livreDto){
        if(livreDto == null){
            return null;
        }
        Livre livre = new Livre();
        livre.setId(livreDto.getId());
        livre.setIsbn(livreDto.getIsbn());
        livre.setDate_Edition(livre.getDate_Edition());
        return livre;
    }
}
