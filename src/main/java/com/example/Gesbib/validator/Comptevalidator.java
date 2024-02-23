package com.example.Gesbib.validator;

import com.example.Gesbib.dto.BibliothequaireDto;
import com.example.Gesbib.dto.CompteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Comptevalidator {
    public static List<String> validate(CompteDto compteDto){
        List<String> errors = new ArrayList<>();
        if(compteDto == null){
            errors.add("veuiller entrer le nom D'utilisateur du compte");
            errors.add("veuiller entrer le mot de passe du compte");
        }

        if(!StringUtils.hasLength(compteDto.getLogin())){
            errors.add("veuiller entrer le nom D'utilisateur du compte");
        }

        if(!StringUtils.hasLength(compteDto.getPassword())){
            errors.add("veuiller entrer le mot de passe du compte");
        }

        return errors;
    }
}
