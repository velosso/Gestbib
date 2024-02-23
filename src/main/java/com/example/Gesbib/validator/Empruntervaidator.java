package com.example.Gesbib.validator;

import com.example.Gesbib.dto.BibliothequaireDto;
import com.example.Gesbib.dto.EmprunterDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Empruntervaidator {
    public static List<String> validate(EmprunterDto emprunterDto){
        List<String> errors = new ArrayList<>();

        if(emprunterDto == null){
            errors.add("veuiller entrer la data d'emprunt");
            errors.add("veuiller entrer la date de retour");
        }
        if(emprunterDto.getDate_Emprunt() == null){
            errors.add("veuiller entrer la data d'emprunt");
        }

        if(emprunterDto.getDate_Retour() == null){
            errors.add("veuiller entrer la date de retour");
        }

        return errors;
    }
}
