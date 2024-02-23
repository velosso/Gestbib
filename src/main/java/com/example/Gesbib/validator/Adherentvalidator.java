package com.example.Gesbib.validator;

import com.example.Gesbib.dto.AdherentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Adherentvalidator {
    public static List<String> validate(AdherentDto adherentDto){
        List<String> errors = new ArrayList<>();

        if(adherentDto == null){
            errors.add("veuiller renseigner le nom de l'adherent");
            errors.add("veuiller renseigner le prenom de l'adherent");
            errors.add("veuiller renseigner le Type d'adhesion de l'adherent");
            errors.add("veuiller renseigner l'Email de l'adherent");
            errors.add("veuiller renseigner le numero de l'adherent");
            errors.add("veuiller renseigner l'adresse de L'adherent");
            errors.add("veuiller renseigner la date de naissance de L'adherent");
            errors.add("veuiller renseigner la date d'adhesion de L'adherent");
        }


        if(!StringUtils.hasLength(adherentDto.getNom())){
            errors.add("veuiller renseigner le nom de l'adherent");
        }
        if(!StringUtils.hasLength(adherentDto.getPrenom())){
            errors.add("veuiller renseigner le prenom de l'adherent");
        }
        if(!StringUtils.hasLength(adherentDto.getTypeAdhesion())){
            errors.add("veuiller renseigner le Type d'adhesion de l'adherent");
        }

        if(!StringUtils.hasLength(adherentDto.getEmail())){
            errors.add("veuiller renseigner l'Email de l'adherent");
        }
        if(!StringUtils.hasLength(adherentDto.getNumTel())){
            errors.add("veuiller renseigner le numero de l'adherent");
        }
        if(!StringUtils.hasLength(adherentDto.getAdress())){
            errors.add("veuiller renseigner l'adresse de L'adherent");
        }

        if(adherentDto.getDateNaissance() == null){
            errors.add("veuiller renseigner la date de naissance de L'adherent");
        }

        if(adherentDto.getDateAdhesion() == null){
            errors.add("veuiller renseigner la date d'adhesion de L'adherent");
        }

        return errors;
    }
}
