package com.example.Gesbib.services;

import com.example.Gesbib.dto.LivreDto;

import java.util.List;

public interface LivreService {
    LivreDto save(LivreDto dto);
    LivreDto findById(Integer id);
    LivreDto findByisbn(String Isbn);
    List<LivreDto> findAll();

    void delete(Integer id);
}
