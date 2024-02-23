package com.example.Gesbib.services;

import com.example.Gesbib.dto.CategorieDto;
import com.example.Gesbib.dto.ReserverDto;

import java.util.List;

public interface ReserverService {
    ReserverDto save(ReserverDto dto);

    ReserverDto findById(Integer id);


    List<ReserverDto> findAll();

    void delete(Integer id);
}
