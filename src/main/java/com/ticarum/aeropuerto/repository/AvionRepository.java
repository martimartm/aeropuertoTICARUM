package com.ticarum.aeropuerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ticarum.aeropuerto.model.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion,Long>{
    
}
