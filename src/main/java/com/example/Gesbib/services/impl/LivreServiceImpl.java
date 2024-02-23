package com.example.Gesbib.services.impl;

import com.example.Gesbib.dto.LivreDto;
import com.example.Gesbib.exeption.EntityNotFoundException;
import com.example.Gesbib.exeption.ErrorCodes;
import com.example.Gesbib.exeption.InvalidEntityException;
import com.example.Gesbib.model.Livre;
import com.example.Gesbib.repository.LivreRepository;
import com.example.Gesbib.services.LivreService;
import com.example.Gesbib.validator.Livrevalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LivreServiceImpl implements LivreService {

    private LivreRepository livreRepository;

    @Autowired
    public LivreServiceImpl( LivreRepository livreRepository){
    this.livreRepository = livreRepository;
    }

    @Override
    public LivreDto save(LivreDto dto){
        List<String> errors = Livrevalidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("le livre n'est pas valide{}", dto);
            throw  new InvalidEntityException("Le livre n'est pas valide", ErrorCodes.LIVRE_NOT_VALID, errors);
        }
        return LivreDto.fromEntity(
                livreRepository.save(
                        LivreDto.toEntity(dto)
                )
        );
    }

    @Override
    public LivreDto findById(Integer id){
        if (id == null){
            log.error("Livre ID is null");
            return null;
        }
        Optional<Livre> livre = livreRepository.findById(id);

        return Optional.of(LivreDto.fromEntity(livre.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "aucun livre avec L'id" + id +"n'a ete trouver dans la Base de donnees",
                        ErrorCodes.LIVRE_NOT_FOUND));
    }

    @Override
    public LivreDto findByisbn(String Isbn){
        if (!StringUtils.hasLength(Isbn)){
            log.error("Livre Isbn is null");
            return null;
        }
        Optional<Livre> livre = livreRepository.findLivreByisbn(Isbn);

        return Optional.of(LivreDto.fromEntity(livre.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "aucun livre avec cette ISBN" + Isbn +"n'a ete trouver dans la Base de donnees",
                        ErrorCodes.LIVRE_NOT_FOUND));
    }

    @Override
    public List<LivreDto> findAll(){
        return livreRepository.findAll().stream()
                .map(LivreDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if (id == null){
            log.error("Livre ID is null");
            return;
        }
        livreRepository.deleteById(id);
    }
}
