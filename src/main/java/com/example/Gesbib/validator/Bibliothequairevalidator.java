package com.example.Gesbib.validator;

import com.example.Gesbib.dto.BibliothequaireDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Bibliothequairevalidator {
    public static List<String> validate(BibliothequaireDto bibliothequaireDto){
        List<String> errors = new ArrayList<>();
        if(bibliothequaireDto == null){
            errors.add("veuiller entrer le nom de la bibliothequaire");
            errors.add("veuiller entrer le Prenom de la bibliothequaire");
            errors.add("veuiller entrer le numero de telephone de la bibliothequaire");
            errors.add("veuiller entrer l'Email de la bibliothequaire");
            errors.add("veuiller entrer l'Adress de la bibliothequaire");
        }

        if(!StringUtils.hasLength(bibliothequaireDto.getNom())){
            errors.add("veuiller entrer le nom de la bibliothequaire");
        }
        if(!StringUtils.hasLength(bibliothequaireDto.getPrenom())){
            errors.add("veuiller entrer le Prenom de la bibliothequaire");
        }
        if(!StringUtils.hasLength(bibliothequaireDto.getNumTel())){
            errors.add("veuiller entrer le numero de telephone de la bibliothequaire");
        }
        if(!StringUtils.hasLength(bibliothequaireDto.getEmail())){
            errors.add("veuiller entrer l'Email de la bibliothequaire");
        }
        if(!StringUtils.hasLength(bibliothequaireDto.getAdress())){
            errors.add("veuiller entrer l'Adress de la bibliothequaire");
        }



        return errors;
    }
}
