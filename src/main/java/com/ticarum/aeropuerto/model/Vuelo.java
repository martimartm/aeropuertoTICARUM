package com.ticarum.aeropuerto.model;
import jakarta.persistence.*;

@Entity
@Table(name="Vuelo")

public class Vuelo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vuelo", nullable = false)
    private Long id_vuelo;

    //Clave foranea tabla aerolinea
    private Aerolinea aerolinea;

    //Clave foranea tabla avion
    private Avion avion;

    public Vuelo(Avion avion){
        this.avion=avion;
    }

}