package com.example.Gesbib.validator;

import com.example.Gesbib.dto.AuteurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Auteurvalidator {

    public static List<String> validate(AuteurDto auteurDto){
        List<String> errors = new ArrayList<>();

        if(auteurDto == null){
            errors.add("veuillez saisir le nom de l'auteur");
            errors.add("veuillez saisir le prenom de l'auteur");
        }
        if(StringUtils.hasLength(auteurDto.getNom())){
            errors.add("veuillez saisir le nom de l'auteur");
        }
        if(StringUtils.hasLength(auteurDto.getPrenom())){
            errors.add("veuillez saisir le prenom de l'auteur");
        }

        return errors;
    }
}
