package com.example.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.entity.Mutante;

@Repository
public interface MutanteRepository extends JpaRepository<Mutante, Long> {
    
}
