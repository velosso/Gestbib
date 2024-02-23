package com.example.Gesbib.dto;

import com.example.Gesbib.model.Exemplaire;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExemplaireDto {
    private Integer id;
    private Number nbre_Exemplaire;

    private ReserverDto reserver;

    public static ExemplaireDto fromEntity(Exemplaire exemplaire){
        if(exemplaire == null){
            return null;
        }

        return  ExemplaireDto.builder()
                .id(exemplaire.getId())
                .nbre_Exemplaire(exemplaire.getNbre_Exemplaire())
                .build();
    }

    public static Exemplaire toEntity(ExemplaireDto exemplaireDto){
        if(exemplaireDto == null){
            return null;
        }
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setId(exemplaireDto.getId());
        exemplaire.setNbre_Exemplaire(exemplaireDto.getNbre_Exemplaire());
        return exemplaire;
    }
}
