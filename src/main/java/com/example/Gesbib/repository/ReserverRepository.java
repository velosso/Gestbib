package com.example.Gesbib.repository;

import com.example.Gesbib.model.Reserver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReserverRepository extends JpaRepository<Reserver, Integer> {
    @Override
    Optional<Reserver>findById(Integer integer);
}
