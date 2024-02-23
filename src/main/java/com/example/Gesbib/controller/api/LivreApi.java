package com.example.Gesbib.controller.api;

import com.example.Gesbib.dto.LivreDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.example.Gesbib.utils.Constants.APP_ROOT;

import java.util.List;

public interface LivreApi {

    @PostMapping(value =  APP_ROOT + "/livres/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LivreDto save(@RequestBody LivreDto dto);

    @GetMapping(value = APP_ROOT + "/livres/{idLivre}", produces = MediaType.APPLICATION_JSON_VALUE)
    LivreDto findById(@PathVariable("idLivre") Integer id);

    @GetMapping(value = APP_ROOT + "/livres/{isbnLivre}", produces = MediaType.APPLICATION_JSON_VALUE)
    LivreDto findByisbn(@PathVariable("isbnLivre") String Isbn);

    @GetMapping(value = APP_ROOT + "/livres/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LivreDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/livres/delete/{idLivre}")
    void delete(@PathVariable("idLivre") Integer id);
}
