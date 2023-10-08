package com.ticarum.aeropuerto.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ticarum.aeropuerto.repository.AerolineaRepository;
import com.ticarum.aeropuerto.repository.AvionRepository;
import com.ticarum.aeropuerto.exception.ResourceNotFoundException;
import com.ticarum.aeropuerto.model.Aerolinea;
import com.ticarum.aeropuerto.model.Avion;


@RestController
@RequestMapping("/{name}/services")
public class AvionController {

    @Autowired
    private AvionRepository avionRepository; 
    @Autowired
    private AerolineaRepository aerolineaRepository;

    @Autowired
    public AvionController(AerolineaRepository aerolineaRepository, AvionRepository avionRepository) {
        this.aerolineaRepository = aerolineaRepository;
        this.avionRepository = avionRepository;
    }

    //Devuelve una lista de todos los aviones pertenecientes a una aerolinea
    @GetMapping("/aviones/{aerolineaId}")
    public ResponseEntity<?> getAllAvionByaerolineaid(@PathVariable(value = "aerolineaId") Long aerolineaId) {
    
        List<Avion> aviones = avionRepository.findByAerolineaId(aerolineaId);
    
        if (aviones.isEmpty()) {
            String mensaje = "La aerolínea no tiene aviones";
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensaje);
        } else {
            return new ResponseEntity<>(aviones, HttpStatus.OK);
        }
    }

       @PostMapping("/aviones/nuevo")
       public Avion crearAvion(@PathVariable("name") String name, @RequestBody Avion nuevoAvion) {
           //System.out.println(name);
           Aerolinea aerolinea = aerolineaRepository.findByName(name);
            //System.out.println(aerolinea);
           if (aerolinea != null) {

           nuevoAvion.setModelo_avion(nuevoAvion.getModelo_avion());
           nuevoAvion.setCapacidad_avion(nuevoAvion.getCapacidad_avion());
           nuevoAvion.setAerolinea(aerolinea);
           nuevoAvion = avionRepository.save(nuevoAvion);
            return nuevoAvion ;

           } else {
               throw new ResourceNotFoundException("Aerolinea no encontrada");
           }
       }
   }
   

   
   
   


