package com.example.Gesbib.dto;

import com.example.Gesbib.model.Sanction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SanctionDto {
    private Integer id;
    private String Type_Sanction;


    private String Motif;


    private PossederDto posseder;

    public static SanctionDto fromEntity(Sanction sanction){
        if(sanction == null){
            return null;
        }
        return SanctionDto.builder()
                .id(sanction.getId())
                .Type_Sanction(sanction.getType_Sanction())
                .Motif(sanction.getMotif())
                .build();
    }

    public static Sanction toEntity(SanctionDto sanctionDto){
        if(sanctionDto == null){
            return null;
        }

        Sanction sanction = new Sanction();
        sanction.setId(sanctionDto.getId());
        sanction.setType_Sanction(sanctionDto.getType_Sanction());
        sanction.setMotif(sanctionDto.getMotif());
        return sanction;
    }
}
