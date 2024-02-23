package com.example.Gesbib.controller;

import com.example.Gesbib.controller.api.LivreApi;
import com.example.Gesbib.dto.LivreDto;
import com.example.Gesbib.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController implements LivreApi {

    private LivreService livreService;

    @Autowired
    public LivreController(LivreService livreService){
        this.livreService = livreService;
    }

    @Override
    public LivreDto save(LivreDto dto){
        return livreService.save(dto);
    }

    @Override
    public LivreDto findById(Integer id){
      return livreService.findById(id);
    }

    @Override
    public LivreDto findByisbn(String Isbn){
        return livreService.findByisbn(Isbn);
    }

    @Override
    public List<LivreDto> findAll(){
        return livreService.findAll();
    }


    @Override
    public void delete(Integer id){
    livreService.delete(id);
    }
}
