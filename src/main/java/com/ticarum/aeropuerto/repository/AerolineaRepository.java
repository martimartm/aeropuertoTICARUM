package com.ticarum.aeropuerto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ticarum.aeropuerto.model.Aerolinea;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea,Long>{
    Aerolinea findByName(String name);
    Aerolinea findByidaerolinea(Long id_aerolinea);
}
