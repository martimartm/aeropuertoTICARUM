package com.ticarum.aeropuerto.controllers;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticarum.aeropuerto.exception.ResourceNotFoundException;
import com.ticarum.aeropuerto.model.Aerolinea;
import com.ticarum.aeropuerto.model.Avion;
import com.ticarum.aeropuerto.model.Vuelo;
import com.ticarum.aeropuerto.repository.AerolineaRepository;
import com.ticarum.aeropuerto.repository.AvionRepository;
import com.ticarum.aeropuerto.repository.VueloRepository;

@RestController
@RequestMapping("/{name}/services")
public class VueloController {

    @Autowired
    private VueloRepository vueloRepository;
    @Autowired
    private AerolineaRepository aerolineaRepository;
        @Autowired
    private AvionRepository avionRepository;

//Crear un  nuevo vuelo
       @PostMapping("/vuelo")
       public Vuelo crearVuelo(@PathVariable("name") String name, @RequestBody Vuelo nuevoVuelo) {
           
        Aerolinea aerolinea = aerolineaRepository.findByName(name);      
        if (aerolinea != null) {
           nuevoVuelo.setAerolinea(aerolinea);
           nuevoVuelo.setEntrada(LocalDateTime.now());
            nuevoVuelo.setSalida(nuevoVuelo.getSalida());

            Avion avion = nuevoVuelo.getAvion();
            nuevoVuelo.setAvion(avion);

            nuevoVuelo = vueloRepository.save(nuevoVuelo);
            return nuevoVuelo ;

           } else {
               throw new ResourceNotFoundException("Aerolinea no encontrada");
           }
       }

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
 
//Usando una petición HTTP GET: Devolverá una lista con los vuelos pendientes de despegar del aeropuerto 
@GetMapping("/vuelo")
public ResponseEntity<List<Vuelo>> getVuelosPendientesDespegar(@PathVariable("name") String name) {
    List<Vuelo> vuelosPendientes = vueloRepository.findVuelosPendientesByAerolinea(name);
    return new ResponseEntity<>(vuelosPendientes, HttpStatus.OK);
}


}
