package com.example.Gesbib.validator;

import com.example.Gesbib.dto.AuteurDto;
import com.example.Gesbib.dto.ExemplaireDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Exemplairevalidator {
    public static List<String> validate(ExemplaireDto exemplaireDto){
        List<String> errors = new ArrayList<>();

        if(exemplaireDto == null){
            errors.add("veuillez saisir le nombre d'exemplaire");

        }



        return errors;
    }
}
