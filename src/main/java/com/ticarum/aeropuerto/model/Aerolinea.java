package com.ticarum.aeropuerto.model;
import jakarta.persistence.*;

@Entity
@Table(name="Aerolinea")

public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_aerolinea", nullable = false)
    private Long id_aerolinea;

    @Column(name="name_aerolinea", nullable = false, unique = true)
    private String name_aerolinea;
//Consulta SQL
//Número de aviones a la tabla avion que corresponda al id de la aerolinea
    public Aerolinea(){

    }
    public Aerolinea (String name_aerolinea ){
        this.name_aerolinea=name_aerolinea;
    }
}