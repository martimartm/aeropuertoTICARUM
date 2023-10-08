package com.ticarum.aeropuerto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ticarum.aeropuerto.model.Aerolinea;
import com.ticarum.aeropuerto.repository.AerolineaRepository;


@RestController
@RequestMapping("/{name}/services")
public class AerolineaController {

    @Autowired
    private AerolineaRepository aerolineaRepository;
    @GetMapping("/info")
    public ResponseEntity<List<Aerolinea>> getAllAerolineas() {
        List<Aerolinea> aerolineas = aerolineaRepository.findAll();
        HttpStatus status = aerolineas.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(aerolineas, status);
    }

    @PostMapping("/info")
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aerolinea> createAerolinea(@RequestBody Aerolinea aerolinea) {
		try {
			Aerolinea newAerolinea = aerolineaRepository.save(new Aerolinea(aerolinea.getName()));
			return new ResponseEntity<>(newAerolinea, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
