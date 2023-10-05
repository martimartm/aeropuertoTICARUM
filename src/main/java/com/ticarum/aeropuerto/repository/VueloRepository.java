package com.ticarum.aeropuerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ticarum.aeropuerto.model.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Long>{
    
}
