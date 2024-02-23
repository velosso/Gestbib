package com.example.Gesbib.services;

import com.example.Gesbib.dto.AuteurDto;

import java.util.List;

public interface AuteurService {

    AuteurDto save (AuteurDto dto);

    AuteurDto findById(Integer id);

    List<AuteurDto> findAll();

    void delete(Integer id);
}
