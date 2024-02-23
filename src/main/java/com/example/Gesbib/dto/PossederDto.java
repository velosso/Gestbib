package com.example.Gesbib.dto;

import com.example.Gesbib.model.Adherent;
import com.example.Gesbib.model.Livre;
import com.example.Gesbib.model.Posseder;
import com.example.Gesbib.model.Sanction;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class PossederDto {
    private Integer id;
    private List<AdherentDto> adherent;

    private List<SanctionDto> sanction;

    public static PossederDto fromEntity(Posseder posseder){
        if(posseder == null){
            return null;
        }
        return  PossederDto.builder()
                .id(posseder.getId())
                .build();
    }

    public static Posseder toEntity(PossederDto possederDto){
        if(possederDto == null){
            return null;
        }

        Posseder posseder = new Posseder();
        posseder.setId(possederDto.getId());
        return posseder;
    }
}
