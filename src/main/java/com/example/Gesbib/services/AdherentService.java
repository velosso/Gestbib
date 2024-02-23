package com.example.Gesbib.services;

import com.example.Gesbib.dto.AdherentDto;

import java.util.List;

public interface AdherentService {
    AdherentDto save(AdherentDto dto);

    AdherentDto findById(Integer id);

    List<AdherentDto> findAll();

    void delete(Integer id);
}
