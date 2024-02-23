package com.example.Gesbib.repository;

import com.example.Gesbib.model.Emprunter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprunterRepository extends JpaRepository<Emprunter, Integer> {
}
