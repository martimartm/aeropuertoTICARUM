package com.ticarum.aeropuerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ticarum.aeropuerto.model.Aerolinea;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea,Long>{
    List<Aerolinea> findByName(String name_aerolinea);
    Aerolinea findByidaerolinea(Long id_aerolinea);
}
