package com.example.Gesbib.validator;

import com.example.Gesbib.dto.AuteurDto;
import com.example.Gesbib.dto.Etat_LivreDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Etat_Livrevalidator {
    public static List<String> validate(Etat_LivreDto etat_livreDto){
        List<String> errors = new ArrayList<>();

        if(etat_livreDto == null){
            errors.add("veuillez saisir l'etat du livre");
        }
        if(StringUtils.hasLength(etat_livreDto.getEtat())){
            errors.add("veuillez saisir l'etat du livre");
        }
        return errors;
    }
}
