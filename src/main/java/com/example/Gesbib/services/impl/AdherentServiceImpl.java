package com.example.Gesbib.services.impl;

import com.example.Gesbib.dto.AdherentDto;
import com.example.Gesbib.exeption.EntityNotFoundException;
import com.example.Gesbib.exeption.ErrorCodes;
import com.example.Gesbib.exeption.InvalidEntityException;
import com.example.Gesbib.repository.AdherentRepository;
import com.example.Gesbib.services.AdherentService;
import com.example.Gesbib.validator.Adherentvalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdherentServiceImpl implements AdherentService {
    private AdherentRepository adherentRepository;

    @Autowired
    public AdherentServiceImpl(AdherentRepository adherentRepository){
        this.adherentRepository = adherentRepository;
    }

    @Override
    public AdherentDto save(AdherentDto dto){
        List<String> errors = Adherentvalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Adherent is not valid{}", dto);
            throw new InvalidEntityException("L'adherent n'est pas valide", ErrorCodes.ADHERENT_NOT_VALID, errors);
        }
        return AdherentDto.fromEntity(
                adherentRepository.save(AdherentDto.toEntity(dto))
        );
    }

    @Override
    public AdherentDto findById(Integer id){
        if(id == null){
            log.error("Categorie ID is null");
            return null;
        }
        return adherentRepository.findById(id)
                .map(AdherentDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune categorie avec L'ID = " + id + " n'a ette trouve dans la base de donnee",
                        ErrorCodes.ADHERENT_NOT_FOUND)
                );
    }



    @Override
    public List<AdherentDto> findAll(){
        return  adherentRepository.findAll().stream()
                .map(AdherentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if(id == null){
            log.error("Adherent ID is null");
            return;
        }
        adherentRepository.deleteById(id);
    }
}
