package com.example.Gesbib.dto;

import com.example.Gesbib.model.Adherent;
import com.example.Gesbib.model.Exemplaire;
import com.example.Gesbib.model.Reserver;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@Builder
@Data
public class ReserverDto {
    private Integer id;
    private String Demande_R;


    private String Annulation_R;


    private String Date_Reservation;


    private List<AdherentDto> adherent;


    private List <ExemplaireDto> exemplaire;

    public static ReserverDto fromEntity(Reserver reserver){
        if(reserver == null){
            return null;
        }
        return ReserverDto.builder()
                .id(reserver.getId())
                .Demande_R(reserver.getDemande_R())
                .Annulation_R(reserver.getAnnulation_R())
                .Date_Reservation(reserver.getDate_Reservation())
                .build();
    }

    public static  Reserver toEntity(ReserverDto reserverDto){
        if(reserverDto == null){
            return null;
        }
        Reserver reserver = new Reserver();
        reserver.setId(reserverDto.getId());
        reserver.setDemande_R(reserverDto.getDemande_R());
        reserver.setAnnulation_R(reserverDto.getAnnulation_R());
        reserver.setDate_Reservation(reserverDto.getDate_Reservation());
        return reserver;
    }
}
