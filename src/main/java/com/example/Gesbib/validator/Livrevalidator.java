package com.example.Gesbib.validator;

import com.example.Gesbib.dto.AuteurDto;
import com.example.Gesbib.dto.LivreDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Livrevalidator {
    public static List<String> validate(LivreDto livreDto){
        List<String> errors = new ArrayList<>();
        if(livreDto == null){
            errors.add("veuillez saisir l'Isbn du livre");
            errors.add("veuillez saisir le titre du livre");
            errors.add("veuillez saisir l'Etat du livre");
            errors.add("veuillez saisir la date d'edition du livre");
            errors.add("veuillez saisir le nom de l'auteur du livre");
            errors.add("veuillez saisir le categorie du livre");
        }
        if(StringUtils.hasLength(livreDto.getIsbn())){
            errors.add("veuillez saisir l'Isbn du livre");
        }
        if(StringUtils.hasLength(livreDto.getTitre())){
            errors.add("veuillez saisir le titre du livre");
        }

        if(livreDto.getEtat_livre() == null){
            errors.add("veuillez saisir l'Etat du livre");
        }
        if(livreDto.getDate_Edition() == null){
            errors.add("veuillez saisir la date d'edition du livre");
        }
        if(livreDto.getAuteur() == null){
            errors.add("veuillez saisir le nom de l'auteur du livre");
        }

        if(livreDto.getCategorie() == null){
            errors.add("veuillez saisir le categorie du livre");
        }
        return errors;
    }
}
