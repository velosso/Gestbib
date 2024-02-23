package com.example.Gesbib.repository;

import com.example.Gesbib.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
    Optional<Livre> findLivreByisbn(String Isbn);

}
