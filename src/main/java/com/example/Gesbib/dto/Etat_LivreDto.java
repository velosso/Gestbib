package com.example.Gesbib.dto;

import com.example.Gesbib.model.Etat_Livre;
import com.example.Gesbib.model.Livre;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@Builder
@Data
public class Etat_LivreDto {
    private Integer id;
    private String Etat;

    private List<LivreDto> livre;

    public static Etat_LivreDto fromEntity(Etat_Livre etat_livre){
        if(etat_livre == null){
            return null;
        }
        return Etat_LivreDto.builder()
                .id(etat_livre.getId())
                .Etat(etat_livre.getEtat())
                .build();
    }

    public  static Etat_Livre toEntity(Etat_LivreDto etat_livreDto){
        if(etat_livreDto == null){
            return null;
        }

        Etat_Livre etat_livre = new Etat_Livre();
        etat_livre.setId(etat_livreDto.getId());
        etat_livre.setEtat(etat_livreDto.getEtat());
        return etat_livre;
    }
}
