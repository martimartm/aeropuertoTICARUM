package com.ticarum.aeropuerto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ticarum.aeropuerto.model.Aerolinea;
import com.ticarum.aeropuerto.repository.AerolineaRepository;


@RestController
@RequestMapping("/services")
public class AerolineaController {

    @Autowired
    private AerolineaRepository aerolineaRepository;


    @GetMapping("/info")
    public List<Aerolinea> getAllAerolineas(){
        return aerolineaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aerolinea createAerolinea(@RequestBody Aerolinea aerolinea){
        return aerolineaRepository.save(aerolinea);
    }
 
}