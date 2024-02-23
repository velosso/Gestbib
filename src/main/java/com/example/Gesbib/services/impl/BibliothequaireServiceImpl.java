package com.example.Gesbib.services.impl;

import com.example.Gesbib.dto.AuteurDto;
import com.example.Gesbib.dto.BibliothequaireDto;
import com.example.Gesbib.exeption.EntityNotFoundException;
import com.example.Gesbib.exeption.ErrorCodes;
import com.example.Gesbib.exeption.InvalidEntityException;
import com.example.Gesbib.repository.AuteurRepository;
import com.example.Gesbib.repository.BibliothequaireRepository;
import com.example.Gesbib.services.BibliothequaireService;
import com.example.Gesbib.validator.Auteurvalidator;
import com.example.Gesbib.validator.Bibliothequairevalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BibliothequaireServiceImpl implements BibliothequaireService {
    private BibliothequaireRepository bibliothequaireRepository;

    @Autowired
    public BibliothequaireServiceImpl(BibliothequaireRepository bibliothequaireRepository){
        this.bibliothequaireRepository = bibliothequaireRepository;
    }

    @Override
    public BibliothequaireDto save(BibliothequaireDto dto){
        List<String> errors = Bibliothequairevalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Bibliothequaire is not valid{}", dto);
            throw new InvalidEntityException("La bibliothequaire n'est pas valide", ErrorCodes.BIBLIOTHEQUAIRE_NOT_VALID, errors);
        }
        return BibliothequaireDto.fromEntity(
                bibliothequaireRepository.save(BibliothequaireDto.toEntity(dto))
        );
    }

    @Override
    public BibliothequaireDto findById(Integer id){
        if(id == null){
            log.error("Auteur ID is null");
            return null;
        }
        return bibliothequaireRepository.findById(id)
                .map(BibliothequaireDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun Auteur avec L'ID = " + id + " n'a ette trouve dans la base de donnee",
                        ErrorCodes.BIBLIOTHEQUAIRE_NOT_FOUND)
                );
    }



    @Override
    public List<BibliothequaireDto> findAll(){
        return  bibliothequaireRepository.findAll().stream()
                .map(BibliothequaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if(id == null){
            log.error("Auteur ID is null");
            return;
        }
        bibliothequaireRepository.deleteById(id);
    }
}
