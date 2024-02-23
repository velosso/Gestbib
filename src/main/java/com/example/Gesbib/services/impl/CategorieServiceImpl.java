package com.example.Gesbib.services.impl;

import com.example.Gesbib.dto.CategorieDto;
import com.example.Gesbib.exeption.EntityNotFoundException;
import com.example.Gesbib.exeption.ErrorCodes;
import com.example.Gesbib.exeption.InvalidEntityException;
import com.example.Gesbib.repository.CategorieRepository;
import com.example.Gesbib.services.CategorieService;
import com.example.Gesbib.validator.Categorievalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository){
        this.categorieRepository = categorieRepository;
    }

    @Override
    public CategorieDto save(CategorieDto dto){
        List<String> errors = Categorievalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("categoris is not valid{}", dto);
            throw new InvalidEntityException("La categorie n'est pas valide", ErrorCodes.CATEGORIE_NOT_VALID, errors);
        }
        return CategorieDto.fromEntity(
                categorieRepository.save(CategorieDto.toEntity(dto))
        );
    }

    @Override
    public CategorieDto findById(Integer id){
        if(id == null){
            log.error("Categorie ID is null");
            return null;
        }
        return categorieRepository.findById(id)
                .map(CategorieDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune categorie avec L'ID = " + id + " n'a ette trouve dans la base de donnee",
                        ErrorCodes.CATEGORIE_NOT_FOUND)
                );
    }

    @Override
     public CategorieDto findByLibele(String libele){
        if(StringUtils.hasLength(libele)){
            log.error("Categorie LIBELE is null");
            return null;
        }
        return categorieRepository.findCategorieByLibele(libele)
                .map(CategorieDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune categorie avec le libele = " + libele + "n' a ete trouve dans la base de donne",
                        ErrorCodes.CATEGORIE_NOT_FOUND)
                );
    }

    @Override
    public List<CategorieDto> findAll(){
        return  categorieRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if(id == null){
            log.error("Categorie ID is null");
            return;
        }
        categorieRepository.deleteById(id);
    }
}
