package com.example.Gesbib.services.impl;

import com.example.Gesbib.dto.ReserverDto;
import com.example.Gesbib.exeption.EntityNotFoundException;
import com.example.Gesbib.exeption.ErrorCodes;
import com.example.Gesbib.exeption.InvalidEntityException;
import com.example.Gesbib.model.Adherent;
import com.example.Gesbib.model.Reserver;
import com.example.Gesbib.repository.AdherentRepository;
import com.example.Gesbib.repository.LivreRepository;
import com.example.Gesbib.repository.ReserverRepository;
import com.example.Gesbib.services.ReserverService;
import com.example.Gesbib.validator.Reservervalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReserverServiceImpl implements ReserverService {

    private ReserverRepository reserverRepository;
    private AdherentRepository adherentRepository;
    private LivreRepository livreRepository;

    @Autowired
    public ReserverServiceImpl(ReserverRepository reserverRepository,
                               AdherentRepository adherentRepository, LivreRepository livreRepository){
        this.reserverRepository = reserverRepository;
        this.adherentRepository = adherentRepository;
        this.livreRepository = livreRepository;
    }

    @Override
    public ReserverDto save(ReserverDto dto){
        List<String> errors = Reservervalidator.validate(dto);

        if(!errors.isEmpty()){
            log.error("reservation n'est pas valide");
            throw  new InvalidEntityException("La reservation client n'est pas valide", ErrorCodes.RESERVER_NOT_VALID, errors);
        }

        Optional<Adherent> adherent = adherentRepository.findById(dto.getId());
        if(adherent.isEmpty()){
            log.warn("Adherent avec l'ID {} n'est pas dans la Base de donnees", dto.getId());
            throw new EntityNotFoundException("Aucun client avec l'ID" + dto.getId() +"n'a ette trouve dans la BDD", ErrorCodes.ADHERENT_NOT_FOUND);
        }

        Reserver saveReseve = reserverRepository.save(ReserverDto.toEntity(dto));
        return null;
    }

    @Override
    public ReserverDto findById(Integer id){
        if (id == null){
            log.error("reservation adherent id est null");
            return  null;
        }
        return reserverRepository.findById(id)
                .map(ReserverDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune resrvation adhereng n'a ette trouve avec l'ID" + id , ErrorCodes.RESERVER_NOT_FOUND
                ));

    }

    @Override
    public List<ReserverDto> findAll(){
        return reserverRepository.findAll().stream()
                .map(ReserverDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if(id == null){
            log.error("reservation ID est null");
            return;
        }
        reserverRepository.deleteById(id);
    }
}
