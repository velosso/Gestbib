package com.example.Gesbib.services.impl;



import com.example.Gesbib.dto.AuteurDto;
import com.example.Gesbib.exeption.EntityNotFoundException;
import com.example.Gesbib.exeption.ErrorCodes;
import com.example.Gesbib.exeption.InvalidEntityException;
import com.example.Gesbib.repository.AuteurRepository;
import com.example.Gesbib.services.AuteurService;
import com.example.Gesbib.validator.Auteurvalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuteurServiceImpl implements AuteurService {
    private AuteurRepository auteurRepository;

    @Autowired
    public AuteurServiceImpl(AuteurRepository auteurRepository){
        this.auteurRepository = auteurRepository;
    }

    @Override
    public AuteurDto save(AuteurDto dto){
        List<String> errors = Auteurvalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Auteur is not valid{}", dto);
            throw new InvalidEntityException("L'auteur n'est pas valide", ErrorCodes.AUTEUR_NOT_VALID, errors);
        }
        return AuteurDto.fromEntity(
                auteurRepository.save(AuteurDto.toEntity(dto))
        );
    }

    @Override
    public AuteurDto findById(Integer id){
        if(id == null){
            log.error("Auteur ID is null");
            return null;
        }
        return auteurRepository.findById(id)
                .map(AuteurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun Auteur avec L'ID = " + id + " n'a ette trouve dans la base de donnee",
                        ErrorCodes.AUTEUR_NOT_FOUND)
                );
    }



    @Override
    public List<AuteurDto> findAll(){
        return  auteurRepository.findAll().stream()
                .map(AuteurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if(id == null){
            log.error("Auteur ID is null");
            return;
        }
        auteurRepository.deleteById(id);
    }
}
