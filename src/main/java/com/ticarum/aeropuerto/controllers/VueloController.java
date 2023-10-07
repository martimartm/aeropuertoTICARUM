package com.ticarum.aeropuerto.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ticarum.aeropuerto.model.Vuelo;
import com.ticarum.aeropuerto.repository.VueloRepository;

@RestController
@RequestMapping("/{name}/services")
public class VueloController {

    @Autowired
    private VueloRepository vueloRepository;

 //Usando una petición HTTP GET: Devolverá los datos del vuelo 
 //identificado por ID_VUELO   
 @GetMapping("/vuelo/{idvuelo}")
public ResponseEntity<?> findById(@PathVariable("idvuelo") Long id_vuelo) {
    Optional<Vuelo> vuelo = vueloRepository.findById(id_vuelo);
    if (vuelo.isPresent()) {
        return ResponseEntity.ok().body(vuelo.get()); 
    } else {
        String mensaje = "Vuelo con ID " + id_vuelo + " no encontrado.";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje); 
    }
}

//Usando una petición HTTP DELETE + Json de datos: Eliminará el vuelo
//identificado por ID_VUELO de la lista de vuelos pendientes de despegar del aeropuerto
@DeleteMapping("/vuelo/{idvuelo}")
public ResponseEntity<?> deleteVuelo(@PathVariable("idvuelo") Long id_vuelo) {
    if (!vueloRepository.existsById(id_vuelo)) {
        String mensaje = "Vuelo con ID " + id_vuelo + " no encontrado.";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
    }
    vueloRepository.deleteById(id_vuelo);
    String mensaje = "Vuelo con ID " + id_vuelo + " ha sido eliminado correctamente.";
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensaje);
}

//Usando una petición HTTP PUT + Json de datos: Editará el vuelo
//identificado por ID_VUELO con los nuevos datos
@PutMapping("/vuelo/{idvuelo}")
public Vuelo updateVuelo(@PathVariable Long idvuelo ,@RequestBody Vuelo vuelo) {
	return vueloRepository.save(vuelo);
}
 
}
