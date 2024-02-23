package com.example.Gesbib.services;

import com.example.Gesbib.dto.CategorieDto;

import java.util.List;

public interface CategorieService  {
    CategorieDto save(CategorieDto dto);

    CategorieDto findById(Integer id);

    CategorieDto findByLibele(String libele);

    List<CategorieDto> findAll();

    void delete(Integer id);
}
