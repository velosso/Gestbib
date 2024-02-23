package com.example.Gesbib.validator;

import com.example.Gesbib.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Categorievalidator {

    public static List<String> validate(CategorieDto categorieDto){
      List<String> errors = new ArrayList<>();

      if(categorieDto == null || !StringUtils.hasLength(categorieDto.getLibele())){
          errors.add("veuiller le libele de la categorie");
      }
      return  errors;
    }
}
