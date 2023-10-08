package com.ticarum.aeropuerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ticarum.aeropuerto.model.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Long>{

    @Query("SELECT v FROM Vuelo v JOIN v.aerolinea al WHERE al.name = ?1 AND v.salida >= CURRENT_TIME")
    List<Vuelo> findVuelosPendientesByAerolinea(String aerolineaName);

    @Query("select v from Vuelo v join v.aerolinea al where al.name = ?1 and v.salida < CURRENT_TIME")
    List<Vuelo> findDespeguesByAerolinea(String aerolineaName);
}
