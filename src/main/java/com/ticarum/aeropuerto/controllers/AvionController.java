package com.ticarum.aeropuerto.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticarum.aeropuerto.repository.AerolineaRepository;
import com.ticarum.aeropuerto.repository.AvionRepository;
import com.ticarum.aeropuerto.model.Avion;


@RestController
@RequestMapping("/{name}/services")
public class AvionController {

    @Autowired
    private AvionRepository avionRepository; 

      @GetMapping("/aviones/{aerolineaId}")
   public ResponseEntity<List<Avion>> getAllAvionByaerolineaid(@PathVariable(value = "aerolineaId") Long aerolineaId) {

    List<Avion> avion = avionRepository.findByAerolineaId(aerolineaId);
    return new ResponseEntity<>(avion, HttpStatus.OK);
  }
}
