package com.example.Gesbib.repository;

import com.example.Gesbib.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findCategorieByLibele(String libele);
}
