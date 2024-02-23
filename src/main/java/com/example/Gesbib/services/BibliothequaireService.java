package com.example.Gesbib.services;

import com.example.Gesbib.dto.BibliothequaireDto;

import java.util.List;

public interface BibliothequaireService {

    BibliothequaireDto save(BibliothequaireDto dto);

    BibliothequaireDto findById(Integer id);

    List<BibliothequaireDto> findAll();

    void delete(Integer id);
}
