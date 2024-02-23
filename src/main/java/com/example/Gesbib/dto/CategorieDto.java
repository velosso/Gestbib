package com.example.Gesbib.dto;

import com.example.Gesbib.model.Categorie;
import com.example.Gesbib.model.Livre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@Builder
@Data
public class CategorieDto {
    private Integer id;

    private String Libele;

    @JsonIgnore
    private List<LivreDto> livre;

    public static CategorieDto fromEntity(Categorie categorie){
        if(categorie == null){
            return null;
        }
        return  CategorieDto.builder()
                .id(categorie.getId())
                .Libele(categorie.getLibele())
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto){
        if(categorieDto == null){
            return null;
        }

        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setLibele(categorieDto.getLibele());

        return categorie;
    }
}
