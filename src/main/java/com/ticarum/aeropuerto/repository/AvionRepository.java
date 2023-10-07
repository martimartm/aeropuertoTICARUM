package com.ticarum.aeropuerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ticarum.aeropuerto.model.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion,Long>{
    @Query("SELECT a FROM Avion a WHERE a.aerolinea.idaerolinea = :aerolineaId")
    public List<Avion> findByAerolineaId(@Param("aerolineaId") Long aerolineaId);
}
