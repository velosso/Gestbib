package com.example.Gesbib.validator;

import com.example.Gesbib.dto.AuteurDto;
import com.example.Gesbib.dto.ReserverDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Reservervalidator {
    public static List<String> validate(ReserverDto reserverDto){
        List<String> errors = new ArrayList<>();

        if(reserverDto == null){
            errors.add("veuillez saisir la demande de Reservation");
            errors.add("veuillez saisir la Date de reservation");
        }

        if(StringUtils.hasLength(reserverDto.getDemande_R())){
            errors.add("veuillez saisir la demande de Reservation");
        }

        if(StringUtils.hasLength(reserverDto.getDate_Reservation())){
            errors.add("veuillez saisir la Date de reservation");
        }
        return  errors;
    }
}
