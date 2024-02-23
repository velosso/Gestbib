package com.example.Gesbib.dto;

import com.example.Gesbib.model.Adherent;
import com.example.Gesbib.model.Emprunter;
import com.example.Gesbib.model.Livre;
import lombok.Builder;
import lombok.Data;


import java.sql.Date;
import java.util.List;

@Builder
@Data
public class EmprunterDto {
    private Integer id;
    private Date Date_Emprunt;

    private Date Date_Retour;

    private List<AdherentDto> adherent;

    private List<LivreDto> livre;

    public static EmprunterDto fromEntity(Emprunter emprunter){
        if(emprunter == null){
            return null;
        }
        return EmprunterDto.builder()
                .id(emprunter.getId())
                .Date_Emprunt(emprunter.getDate_Emprunt())
                .Date_Retour(emprunter.getDate_Retour())
                .build();
    }

    public static Emprunter toEntity(EmprunterDto emprunterDto){
        if(emprunterDto == null){
            return null;
        }
        Emprunter emprunter = new Emprunter();
        emprunter.setId(emprunterDto.getId());
        emprunter.setDate_Emprunt(emprunterDto.getDate_Emprunt());
        emprunter.setDate_Retour(emprunterDto.getDate_Retour());
        return emprunter;
    }

}
