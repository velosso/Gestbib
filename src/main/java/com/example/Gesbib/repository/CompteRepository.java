package com.example.Gesbib.repository;

import com.example.Gesbib.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
}
